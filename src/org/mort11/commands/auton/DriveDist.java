package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.util.DTConstants;
import org.mort11.util.Profiler;

public class DriveDist extends Command {

    private double driveDistance;
    private DTSide left = Robot.left;
    private DTSide right = Robot.right;
    private Profiler profiler;
    private Timer timer;
    private double lastTime = 0;
    double setpoint = 0;

    public DriveDist(double distance) {
        requires(left);
        requires(right);
        profiler = new Profiler(11, 3); //because math
        timer = new Timer();
    }

    protected void initialize() {
        System.out.println("initing");
        DTSide.resetEnc();
        timer.start();
    }

    protected void execute() {
        double currtime = timer.get();
        System.out.println(currtime + " time ");
        double vel = profiler.getDesiredVelocity(currtime);
        System.out.println(vel + " vel");
        setpoint += (currtime - lastTime) * vel;
        System.out.println(setpoint);
        System.out.println(DTSide.getDist() + " left ");
        System.out.println(DTSide.getDist() + " right ");
        double errorLeft = (setpoint - DTSide.getDist());
        double errorRight = (setpoint - DTSide.getDist());
        System.out.println(errorRight * DTConstants.DT_P + " errorRight");
        System.out.println(errorLeft * DTConstants.DT_P + " errorLeft");
        //System.out.println(errorLeft);
        right.set(errorRight * DTConstants.DT_P);
        left.set(errorLeft * DTConstants.DT_P);
        System.out.println();
        lastTime = currtime;
    }

    protected boolean isFinished() {
        return timer.get() > 3;
    }

    protected void end() {
        System.out.println(DTSide.getDist() + " left distance");
        System.out.println(DTSide.getDist() + " right distance");
        System.out.println(setpoint + " sp");
        System.out.println("Finished.");
        DTSide.resetEnc();
        DTSide.resetEnc();
    }

    protected void interrupted() {
    }
}
