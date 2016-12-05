package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Drive extends Subsystem {
    
 
    public void initDefaultCommand() {
    	RobotMap.driveTrain.arcadeDrive(0,0);
    }
    public static void arcadeDrive(double drive, double turn){
    	RobotMap.driveTrain.arcadeDrive(drive, turn);
    }
}

