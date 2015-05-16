package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.ee.*;

public class ThreeToteCentered extends CommandGroup {

    public ThreeToteCentered() {
        //get the first one
        addSequential(new Zero());
        addSequential(new ElevateToHeight(3));
        //turn around and knock over can
        addSequential(new Turn90());
        addSequential(new Turn90());
        //get tote2
        addSequential(new GhettoerDrive(0.7, 0.4));
        addParallel(new FlipIntake());
        addParallel(new IntakeLeft(0.3));
        addParallel(new IntakeRight(0.3));
        addSequential(new WaitTime(0.5));
        //pick up tote2
        addSequential(new Zero());
        addSequential(new ElevateToHeight(4));
        //displace cans
        addSequential(new FlipIntake());
        addParallel(new IntakeLeft(-1));
        addParallel(new IntakeRight(-1));
        addParallel(new GhettoerDrive(2, 0.4));
        addSequential(new WaitTime(2));
        //get tote 3
        addSequential(new Zero());
        addSequential(new ElevateToHeight(4));
        addParallel(new IntakeLeft(0));
        addParallel(new IntakeRight(0));
        //turn around
        addSequential(new Turn90());
        //i am speed
        //kachow
        addSequential(new GhettoerDrive(0.8, 0.8));
        addSequential(new Zero());
        addSequential(new GhettoerDrive(0.8, -0.8));
        addParallel(new IntakeLeft(0));
        addParallel(new IntakeRight(0));
    }
}
