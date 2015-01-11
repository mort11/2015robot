package org.usfirst.frc.team11.robot.subsystems.ee;

import org.usfirst.frc.team11.robot.commands.ee.Elevate;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VerticalActuator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
       setDefaultCommand(new Elevate());
    }
}

