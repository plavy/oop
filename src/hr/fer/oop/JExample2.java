package hr.fer.oop;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class JExample2 extends JFrame {

	public JExample2() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("BLACK LIVES MATTER");
		getContentPane().setBackground(Color.BLACK);
		
		
		JButton gumb = new JButton();
		gumb.setOpaque(false);
		gumb.setContentAreaFilled(false);
		gumb.setBorderPainted(false);
		gumb.addActionListener((e) -> super.dispose());
		add(gumb);
		
		getRootPane().setDefaultButton(gumb);
		
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				JFrame window = new JExample2();
				window.setBounds(0, 0, 5000, 4000);
				window.setVisible(true);
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
