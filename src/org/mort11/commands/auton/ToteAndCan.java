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
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new Zero());
    	addSequential(new ElevateToHeight(3, true));
    	addSequential(new GhettoerDrive(0.5));
    	addSequential(new IntakeBoth(EEConstants.INTAKE_IN_SPEED));
    	addSequential(new WaitTime(1));
    	addSequential(new OneTote());
    }
}
