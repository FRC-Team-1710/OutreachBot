
package org.usfirst.frc.team1710.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    SendableChooser chooser;
    double turn, move, shooter, hopper, shooterMultiplier, leftGearTargetDist, rightGearTargetDist;
    double[] centerX, centerY, defaultValue;
    boolean speedBoost, shoot, stegActive, approachGear;
    Command autonomousCommand;
    
    public static NetworkTable table;
    
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("ez", AutoChallengeGroup);
        SmartDashboard.putData("Auto choices", chooser);
        RobotMap.driveTrain = new RobotDrive(3, 2, 4, 5);
        RobotMap.drive = new Joystick(0);
        Drive.arcadeDrive(0, 0, speedBoost);
        RobotMap.hopper = new Talon(0);
        RobotMap.shooter = new Talon(1);
        RobotMap.navx = new AHRS(SPI.Port.kMXP); 
        turn = 0;
        table = NetworkTable.getTable("GRIP/ContourReport");
        move = 0;
        defaultValue = new double[2];
        defaultValue[0] = 0;
        defaultValue[1] = 1;
        //hopper = 0;
        //shooter = 0;

    }
    

    public void autonomousInit() {
    	autonomousCommand = (Command) chooser.getSelected();
    	autonomousCommand.start();
    }


    public void autonomousPeriodic() {

    }

    @SuppressWarnings("deprecation")
	public void teleopPeriodic() {
        turn = RobotMap.drive.getRawAxis(2);
        move = RobotMap.drive.getRawAxis(1);
        approachGear = RobotMap.drive.getRawButton(3);
        shooterMultiplier = RobotMap.drive.getRawAxis(3);
        stegActive = RobotMap.drive.getRawButton(1);
        
        centerX = table.getNumberArray("centerX", defaultValue);
        centerY = table.getNumberArray("centerY", defaultValue);
        /*SmartDashboard.putDouble("centerX-1", centerX[0]);
        SmartDashboard.putDouble("centerY-1", centerY[0]);
        SmartDashboard.putDouble("centerX-2", centerX[1]);
        SmartDashboard.putDouble("centerY-2", centerY[1]);*/
        
        //shoot = RobotMap.drive.getRawButton(1);
        speedBoost = RobotMap.drive.getRawButton(2);
        
        if(stegActive) {
            Drive.stegDrive(move, RobotMap.navx.getYaw(), stegActive);	
        } else if(approachGear){
        	leftGearTargetDist = Math.abs(320-centerX[0]);
        	rightGearTargetDist = Math.abs(320-centerX[1]);
        	
        	if(Math.abs(leftGearTargetDist-rightGearTargetDist) > 10) {
        		if(leftGearTargetDist > rightGearTargetDist) {
        			//turn to the right
        			RobotMap.driveTrain.arcadeDrive(0, 0.4);
        		} else{
        			//drive straight
        			RobotMap.driveTrain.arcadeDrive(0, -0.4);
        		}
        	} else {
    			RobotMap.driveTrain.arcadeDrive(0.65, 0);
        	}
        } else {
            Drive.arcadeDrive(move, turn, speedBoost);
        }

        
        if(approachGear) {

        }
        //hopper = RobotMap.drive.getRawAxis(3);
        //RobotMap.hopper.set(hopper*-1);
        shooter = RobotMap.drive.getRawAxis(2);
    }
    

    public void testPeriodic() {
    
    }
    
}
