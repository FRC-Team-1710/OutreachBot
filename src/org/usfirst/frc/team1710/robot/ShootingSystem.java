package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	RobotMap.shooter.set(0);
    	RobotMap.hopper.set(0);
    }
    
    public static void runHopper(double speed) {
    	RobotMap.hopper.set(speed);
    }
    
    public static void runShooter(boolean shooting) {
    	if(shooting) {
    		RobotMap.shooter.set(-1);
    	} else {
    		RobotMap.shooter.set(0);
    	}
    }
}

