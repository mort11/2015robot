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
    	System.out.println("driving");
    	addSequential(new GhettoerDrive(1,0.45));
    	System.out.println("done driving");
    	for(int i = 0; i < 3; i++) {
    		//pick up
    		System.out.println("picking up");
    		addSequential(new Zero());
    		addSequential(new ElevateToHeight(2));
    		addSequential(new WaitTime(1));
    		//get the can out of the way
    		System.out.println("displacing can");
    		addSequential(new FlipIntake());
    		addParallel(new IntakeLeft(1));
    		addParallel(new IntakeRight(-1));
    		addSequential(new GhettoerDrive(1,0.25));
    		//reset state 
    		System.out.println("resetting intake");
    		addParallel(new IntakeBoth(0));
    		addSequential(new FlipIntake());
    		//drive up
    		System.out.println("driving");
    		addSequential(new GhettoerDrive(1,0.45));
    		System.out.println("done driving");
    	}
    	addSequential(new Turn());
    	addSequential(new GhettoerDrive(2.5, 0.45));
    	addSequential(new Zero());
    	addSequential(new GhettoerDrive(2.5,-0.45));
    }
}
