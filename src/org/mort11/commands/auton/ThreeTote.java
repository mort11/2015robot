package org.mort11.commands.auton;

import org.mort11.commands.ee.ElevateToHeight;
import org.mort11.commands.ee.FlipIntake;
import org.mort11.commands.ee.IntakeBoth;
import org.mort11.commands.ee.IntakeLeft;
import org.mort11.commands.ee.IntakeRight;
import org.mort11.commands.ee.Zero;
import org.mort11.util.EEConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeTote extends CommandGroup {
    public  ThreeTote() {
    	addParallel(new FlipIntake());
    	//addSequential(new DriveDist(11));
    	for(int i = 0; i < 3; i++) {
    		//pick up
    		addParallel(new FlipIntake());
    		addSequential(new Zero());
    		addSequential(new ElevateToHeight(4));
    		addSequential(new WaitTime(1));
    		//get the can out of the way 
    		addParallel(new IntakeLeft(1));
    		addParallel(new IntakeRight(-1));
    		addSequential(new GhettoerDrive(1));
    		//reset state 
    		addParallel(new IntakeBoth(0));
    		addSequential(new FlipIntake());
    		//drive up
    		System.out.println("driving");
    		addSequential(new GhettoerDrive(1));
    		System.out.println("done driving");
    	}
    }
}
