package org.mort11.commands.auton;
//swag

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;

public class TwoCan extends Command {
    Timer time = new Timer();

    public TwoCan() {
        requires(Robot.canArms);
        requires(Robot.left);
        requires(Robot.right);
    }

    protected void initialize() {
        time.start();
        //drop arms
        Robot.canArms.setSolenoid(false); //if the arms
        //drop out automatically then comment out this line

    }

    protected void execute() {
        //flip positive to negative to change direction of the spin
        //this part is the turn
        //Robot.left.set(0.6);
        //Robot.right.set(0.6);
    }

    protected boolean isFinished() {
        //when to stop spinning
        return time.get() > 1; //the time spent spinning (currently 1s)
    }

    protected void end() {
        //stow away the arms after cans have been grabbed
        Robot.canArms.setSolenoid(true); //comment this in
        //to put the arms back in
    }

    protected void interrupted() {
    }
}
