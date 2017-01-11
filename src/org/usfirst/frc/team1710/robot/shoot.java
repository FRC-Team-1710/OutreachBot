package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class shoot extends Command {

		double speedPublic;
		int timePublic;
		boolean shooterReady;
		boolean done;
    public shoot(double speed, int time) {
    	speedPublic = speed;
    	timePublic = time;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(shooterReady == false) {
    		try {
        		RobotMap.shooter.set(speedPublic *-1);
				delay(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		shooterReady = true;
    		
    	}else{
    		RobotMap.hopper.set(speedPublic * -1);
    		RobotMap.shooter.set(speedPublic * -1);
    		try {
				delay(timePublic);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    		done = true;
    	}
    }
    
    public void delay(int milli) throws InterruptedException {
    	Thread.sleep(milli);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(done == true){
        	RobotMap.hopper.set(0);
        	RobotMap.shooter.set(0);
        }
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
