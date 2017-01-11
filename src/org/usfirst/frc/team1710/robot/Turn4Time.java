package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn4Time extends Command {
	public double powerPublic, timePublic;
	int count;
	boolean done;
	

    public Turn4Time(double power, double time) {
        
    	powerPublic = power;
    	timePublic = time;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(count <= timePublic / 20 ){
    		count++;
    		RobotMap.driveTrain.arcadeDrive(0, powerPublic);
    		done = false; 
    	}
    	else{
    		done = true;
    
    	}
    		
    	
    	   }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
        
        
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
