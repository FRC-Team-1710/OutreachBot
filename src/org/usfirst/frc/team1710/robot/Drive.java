package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Drive extends Subsystem {
    
 
    public void initDefaultCommand() {
    	RobotMap.driveTrain.arcadeDrive(0,0);
    }
    public static void arcadeDrive(double drive, double turn, boolean boost){
    	if(boost) {
    		RobotMap.driveTrain.arcadeDrive(drive * -1, turn * -1);
    	}else{
    		RobotMap.driveTrain.arcadeDrive(drive * -0.6, turn * -0.6);
    	}
    }
}

