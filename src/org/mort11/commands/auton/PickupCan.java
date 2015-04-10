package org.mort11.commands.auton;

import org.mort11.commands.ee.ElevateToHeight;
import org.mort11.commands.ee.Zero;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickupCan extends CommandGroup {

	public PickupCan() {
		addSequential(new ElevateToHeight(4));
		addSequential(new WaitTime(1));
		//addSequential(new TurnWithEncoders(.25));
//		addSequential(new WaitTime(.5));
		addSequential(new GhettoerDrive(3, -0.9));
		//addSequential(new Zero());
		// addSequential(new GhettoerDrive(.5, -.25));
	}
}
