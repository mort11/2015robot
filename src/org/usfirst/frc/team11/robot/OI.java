package org.usfirst.frc.team11.robot;

import org.usfirst.frc.team11.robot.commands.ee.ElevateToHeight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	Joystick left = new Joystick(1);
	Joystick right = new Joystick(2);
	Joystick ee = new Joystick(3);
	Button scoringOffset = new JoystickButton(ee,2);
	Button presetOneTote = new JoystickButton(ee,11);
	Button presetTwoTote = new JoystickButton(ee,12);
	Button presetThreeTote = new JoystickButton(ee,9);
	Button presetFourTote = new JoystickButton(ee,10);
	Button presetFiveTote = new JoystickButton(ee,7);
	Button presetSixTote = new JoystickButton(ee,8);
	public OI()
	{
		presetOneTote.whenPressed(new ElevateToHeight(0));
		presetTwoTote.whenPressed(new ElevateToHeight(1));
		presetThreeTote.whenPressed(new ElevateToHeight(2));
		presetFourTote.whenPressed(new ElevateToHeight(3));
		presetFiveTote.whenPressed(new ElevateToHeight(4));
		presetSixTote.whenPressed(new ElevateToHeight(5));
	}
	public boolean getScoringOffset()
	{
		return scoringOffset.get();
	}
}