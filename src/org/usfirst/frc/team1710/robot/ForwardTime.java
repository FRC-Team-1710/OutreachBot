package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForwardTime extends Command {
	public double powerPublic;
	public double timePublic;
	int count;
	boolean done;
    public ForwardTime(double power, double time) {
        powerPublic = power;
        timePublic = time;
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (count <= timePublic/20) {
    			RobotMap.driveTrain.arcadeDrive(powerPublic,0);
    		count++;
    		done = false;
    	}
    	else {
    		done = true;
    	}
    }

    protected boolean isFinished() {
    
        return done;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
