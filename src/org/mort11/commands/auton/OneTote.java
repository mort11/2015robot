package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneTote extends CommandGroup {
    public  OneTote() {
    	System.out.println("turning");
    	addSequential(new Turn());
    	System.out.println("turnt");
    	addSequential(new GhettoerDrive(3.5));
    }
}
