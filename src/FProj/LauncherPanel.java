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
		setButton.addActionListener(new ChangeListener());
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
			
			String speedString = "";
			double velOutput = Double.parseDouble(velocity.getText());
			
			if(velOutput <= 1)
				speedString = "as slow as a Tortoise!";
			else if(velOutput > 1 && velOutput <= 7)
				speedString = "the same speed as a Black Mamba slithers! SSSSSSSS!";
			else if(velOutput > 7 && velOutput <= 17)
				speedString = "the same speed as a human being runs! I dare you to run into a castle!";
			else if(velOutput > 17 && velOutput <=24)
				speedString = "as fast as an unladen swallow. What do you mean, African or European?";
			else if(velOutput > 24 && velOutput <= 30)
				speedString = "as fast as a cottontail! And they say the tortoise always wins.";
			else if(velOutput > 30 && velOutput <= 40)
				speedString = "the same speed as a track dog runs!";
			else if(velOutput > 40 && velOutput <= 50)
				speedString = "the same speed as a gazelle! Watch out for that lion!";
			else if(velOutput > 50 && velOutput <= 75)
				speedString = "the same speed as a cheetah! Cheetah's are some of the world's fastest land runners!";
			else if(velOutput > 75 && velOutput <= 260)
				speedString = "the same speed as a peregrin falcon dives! That's CRAZY fast!";
			else if(velOutput > 260 && velOutput <= 760)
				speedString = "the same speed as modern landspeed records! Slow it down!";
			else
				speedString = "faster than the speed of sound! That's insane!";

			messageField.setText("You threw that taco " + speedString + " Nice going!");
			FProjMain.getMain().fly();
		}
	}
	
}
