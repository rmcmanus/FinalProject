package FProj;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LauncherPanel extends JPanel{
	private JTextField velocity, angle, messageField;
	private JButton launch;
	public LauncherPanel() {
		setLayout(new BorderLayout());
		messageField = new JTextField(20);
		messageField.setText("Want to know how fast you're going?");
		add(messageField, BorderLayout.NORTH);
		add(labels(), BorderLayout.CENTER);
		launch = new JButton("Launch!");
		launch.addActionListener(new LaunchListener());
		add(launch, BorderLayout.SOUTH);
	}
	
	public JPanel labels() {
		JPanel panel = new JPanel();
		
		JLabel velocityLabel = new JLabel("Velocity");
		panel.add(velocityLabel);
		
		velocity = new JTextField(5);
		velocity.setText("0");
		velocity.setFont(new Font("SnasSerif", Font.BOLD, 12));
		velocity.addFocusListener(new VelocityListener());
		panel.add(velocity);
		
		JLabel angleLabel = new JLabel("Angle");
		panel.add(angleLabel);
		
		angle = new JTextField(5);
		angle.setText("0");
		angle.setFont(new Font("SnasSerif", Font.BOLD, 12));
		angle.addFocusListener(new AngleListener());
		panel.add(angle);
		
		JButton setButton = new JButton("Calculate Trajectory");
		panel.add(setButton);
		
		
		
		return panel;
	}
	
	private class VelocityListener implements FocusListener {
		// We don’t care when we get focus
		public void focusGained(FocusEvent e) {}
		// When we lose focus, need to update the display
		public void focusLost(FocusEvent e) {
			//System.out.println("Velocity works");
			//set velocity
			TacoLauncher.getLauncher().changeVelocity(Double.parseDouble(velocity.getText()));
		}
	}
	
	private class AngleListener implements FocusListener {
		// We don’t care when we get focus
		public void focusGained(FocusEvent e) {}
		// When we lose focus, need to update the display
		public void focusLost(FocusEvent e) {
			//System.out.println("Angle works");
			//set angle
			TacoLauncher.getLauncher().changeAngle(Double.parseDouble(angle.getText()));
		}
	}
	
	public class ChangeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FProjMain.getMain().repaint();
		}
	}
	
	public class LaunchListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//System.out.println("Button Works");
			//Launch!
			if(Double.parseDouble(velocity.getText()) < 5) {
				messageField.setText("SLOW");
			}
			else {
				messageField.setText("SLOW THE HECK DOWN");
			}
			FProjMain.getMain().fly();
		}
	}
	
}
