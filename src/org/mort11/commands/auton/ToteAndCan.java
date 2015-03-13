package org.mort11.commands.auton;

import org.mort11.commands.ee.ElevateToHeight;
import org.mort11.commands.ee.FlipIntake;
import org.mort11.commands.ee.IntakeBoth;
import org.mort11.commands.ee.Zero;
import org.mort11.util.EEConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ToteAndCan extends CommandGroup {
    
    public  ToteAndCan() {
    	addSequential(new Zero());
    	addSequential(new ElevateToHeight(4));
    	addSequential(new GhettoerDrive(0.5));
    	addSequential(new FlipIntake());
    	addSequential(new FlipIntake());
    	addSequential(new IntakeBoth(EEConstants.INTAKE_IN_SPEED));
    	addSequential(new WaitTime(1));
    	addSequential(new IntakeBoth(0));
    	addSequential(new OneTote());
    }
}
