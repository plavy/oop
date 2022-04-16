package hr.fer.oop;

import java.lang.Runnable;
import java.lang.Thread;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class JExample extends JFrame {
	JProgressBar bar = new JProgressBar();
	JButton start = new JButton("Start");
	JTextArea field = new JTextArea("Spreman za polazak");
	JScrollPane scroll = new JScrollPane(field);
	
	public JExample() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getRootPane().setDefaultButton(start);
		setLayout(new BorderLayout());
		
		JPanel buttons = new JPanel();
		buttons.add(start);

		JPanel action = new JPanel();
		action.add(new JLabel("Progress", JLabel.CENTER));
		action.add(bar);
		
		JPanel dolje = new JPanel();
		var layout = new CardLayout();
		dolje.setLayout(layout);
		dolje.add(buttons, "1");
		dolje.add(action, "2");
		layout.show(dolje, "1");
		
		
		add(dolje, BorderLayout.SOUTH);
		add(scroll);
		field.setEditable(false);
		
		start.addActionListener(e -> {
			layout.show(dolje, "2");
			SwingWorker<String, String> load = new SwingWorker<>() {

				@Override
				protected String doInBackground() throws Exception {
					for(int i = 0;i<100;i++) {
						Thread.sleep(200);
						setProgress(i+1);
						if(i % 10 == 0)	publish(String.valueOf(i));
					}
					
					return "Gotov";
				}
				
				protected void process(List<String> chunks) {
					for(String i : chunks) print("Trenutno na: " + i);
			    }
				
				protected void done() {
					try {
						print(get());
					} catch (Exception e) {}
					layout.show(dolje, "1");
					bar.setValue(0);
			    }
				
			};
			load.addPropertyChangeListener(i -> {
				if(i.getPropertyName().equals("progress")) bar.setValue((int)i.getNewValue());
			});
			load.execute();
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame window = new JExample();
			window.setBounds(500, 300, 500, 200);
			window.setVisible(true);
		});
	}
	
	public void print(String s) {
		field.setText(field.getText() + "\n" + s);
	}
}
