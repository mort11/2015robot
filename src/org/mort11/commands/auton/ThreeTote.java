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
    	//addSequential(new GhettoerDrive(1,0.45));
    	System.out.println("done driving");
    	addSequential(new CrayTurn());
    	addSequential(new FlipIntake());
    	addSequential(new FlipIntake());
    	addParallel(new IntakeLeft(1));
    	addParallel(new IntakeRight(1));
    	addSequential(new WaitTime(0.5));
    	for(int i = 0; i < 2; i++) {
    		//pick up
    		System.out.println("picking up");
    		addSequential(new Zero());
    		addSequential(new ElevateToHeight(4));
    		//get the can out of the way
    		System.out.println("displacing can");
    		addSequential(new FlipIntake());
    		addParallel(new IntakeLeft(-1));
    		addParallel(new IntakeRight(-1));
    		addParallel(new GhettoerDrive(0.8,0.4));
    		addSequential(new WaitTime(0.9));
    		//reset state 
    		System.out.println("resetting intake");
    		addSequential(new IntakeBoth(0));
    		addSequential(new FlipIntake());
    		//drive up
    		System.out.println("driving");
    		addSequential(new GhettoerDrive(0.9,0.3));
    		System.out.println("done driving");
    		addSequential(new FlipIntake());
    		addParallel(new IntakeLeft(0.8));
    		addParallel(new IntakeRight(0.8));
    		addSequential(new WaitTime(0.5));
    		addParallel(new IntakeLeft(0.3));
    		addParallel(new IntakeRight(0.3));
    		addSequential(new WaitTime(1));
    }
    	addParallel(new IntakeLeft(0));
    	addParallel(new IntakeRight(0));
    	addSequential(new Turn90());
    	//i am speed
    	//kachow
    	addSequential(new GhettoerDrive(0.8, 0.8));
    	addSequential(new FlipIntake());
    	addSequential(new Zero());
    	addSequential(new GhettoerDrive(0.8,-0.8));
    	addParallel(new IntakeLeft(0));
    	addParallel(new IntakeRight(0));
    }
}
