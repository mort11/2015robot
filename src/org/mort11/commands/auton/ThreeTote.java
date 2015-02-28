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
    	for(int i = 0; i < 3; i++) {
    		//drive up
    		addSequential(new DriveDist(11));
    		//pick up
    		addSequential(new Zero());
    		addSequential(new ElevateToHeight(1, true));
    		//get the can out of the way 
    		addSequential(new FlipIntake());
    		addParallel(new IntakeLeft(EEConstants.INTAKE_OUT_SPEED));
    		addParallel(new IntakeRight(-EEConstants.INTAKE_OUT_SPEED));
    		addSequential(new DriveDist(1));
    		//reset state
    		addParallel(new IntakeBoth(0));
    		addSequential(new FlipIntake());
    	}
    }
}
