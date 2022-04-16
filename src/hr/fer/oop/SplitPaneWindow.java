package hr.fer.oop;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SplitPaneWindow extends JFrame{
	private Map<String, UserData> userData;
	private JSplitPane splitP;
	private JPanel buttonsP;
	private ActionListener toggleListener;
	InputUserDataPanel userDataP;
	
	public SplitPaneWindow() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Podaci o korisnicima");
		
		splitP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(splitP, BorderLayout.CENTER);
		
		buttonsP = new JPanel();
		buttonsP.setLayout(new GridLayout(0, 1));
		
		userDataP = new InputUserDataPanel();
		
		splitP.setLeftComponent(buttonsP);
		splitP.setRightComponent(userDataP);
		
		userData = UserDataFactory.getData();
		
		toggleListener = (e) -> {
			String uid = e.getActionCommand();
			deselectOthers((JToggleButton) e.getSource());
			userDataP.setUserData(userData.get(uid));
			((JToggleButton) e.getSource()).setSelected(true);
		};
		
		for(var entry : userData.entrySet()) {
			JToggleButton button = null;
			if(entry.getValue().getFirstName().equals("")) {
				button = new JToggleButton("Neimenovano");
			} else {
				button = new JToggleButton(entry.getValue().getFirstName() + " " + entry.getValue().getLastName());
			}
			button.setActionCommand(entry.getKey());
			button.addActionListener(toggleListener);
			buttonsP.add(button);
		}
		
		createToolbar();
		selectFirst();
	}
	
	private void deselectOthers(JToggleButton source) {
		for(Component c : source.getParent().getComponents()) {
			if(c instanceof JToggleButton) {
				JToggleButton button = (JToggleButton) c;
				if( button != source && button.isSelected()) {
					String uid = button.getActionCommand();
					UserData data = userDataP.getUserData();
					userData.put(uid, data);
					if(data.getFirstName().equals("")) {
						button.setText("Neimenovano");
					} else {
						button.setText(data.getFirstName() + " " + data.getLastName());
					}
					button.setSelected(false);
				}
			}
		}
	}

	private void selectFirst() {
		if(userData.size() > 0) {
			for(Component c : buttonsP.getComponents()) {
				if(c instanceof JToggleButton) {
					((JToggleButton) c).doClick();
					break;
				}
			}
		} else {
			splitP.setVisible(false);
		}
		
	}

	private void createToolbar() {
		JToolBar toolbar = new JToolBar();
		add(toolbar, BorderLayout.NORTH);
		var newButton = new JButton("New");
		toolbar.add(newButton);
		var delButton = new JButton("Delete");
		toolbar.add(delButton);
		
		newButton.addActionListener((e) -> {
			String uid = UUID.randomUUID().toString();
			userData.put(uid, new UserData());
			
			JToggleButton button = new JToggleButton("Neimenovano");
			button.setActionCommand(uid);
			button.addActionListener(toggleListener);
			buttonsP.add(button);
			buttonsP.updateUI();
			splitP.setVisible(true);
			button.doClick();
		});
		
		delButton.addActionListener((e) -> {
			JToggleButton selectedButton = null; 
			for(Component c : buttonsP.getComponents()) {
				if(c instanceof JToggleButton) {
					JToggleButton button = (JToggleButton) c;
					if(button.isSelected()) {
						selectedButton = button;
						break;
					}
				}
			}
			if(selectedButton != null) {
				buttonsP.remove(selectedButton);
				buttonsP.revalidate();
				userData.remove(selectedButton.getActionCommand());
				selectFirst();
			}
		}); 
	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				SplitPaneWindow frame = new SplitPaneWindow();
				frame.setBounds(600, 200, 500, 400);
				frame.setVisible(true);
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
