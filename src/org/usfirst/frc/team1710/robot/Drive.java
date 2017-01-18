package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	static boolean yawZeroed;
	
    public void initDefaultCommand() {
    	RobotMap.driveTrain.arcadeDrive(0,0);
    	RobotMap.navx.zeroYaw();
    }
    public static void arcadeDrive(double drive, double turn, boolean boost){
    	if(boost) {
    		RobotMap.driveTrain.arcadeDrive(drive * -1, turn * -1);
    	}else{
    		RobotMap.driveTrain.arcadeDrive(drive * -0.6, turn * -0.6);
    	}
    }
    
    public static void stegDrive(double speed, float currentYaw, boolean stegActivated) {
    	if(stegActivated) {
        	if(yawZeroed) {
        		if(currentYaw > 5) {
        			//turns to the left if robots is off course to the right
        			RobotMap.driveTrain.arcadeDrive(speed, 1/currentYaw);
        		} else if(currentYaw < -5) {
        			//turns to the right if robot is off course to the left
        			RobotMap.driveTrain.arcadeDrive(speed, 1/currentYaw);
        		}
        	} else {
        		RobotMap.navx.zeroYaw();
        		yawZeroed = true;
        	}
    	} else {
        	yawZeroed = false;
    	}
    }
}

