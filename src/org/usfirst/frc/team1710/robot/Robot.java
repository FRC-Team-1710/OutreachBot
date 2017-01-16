
package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    SendableChooser chooser;
    double turn, move, shooter, hopper, shooterMultiplier;
    boolean speedBoost, shoot;
    Command autonomousCommand;
    
    NetworkTable table;
    
    public void robotInit() {
        chooser = new SendableChooser();
        SmartDashboard.putData("Auto choices", chooser);
        RobotMap.driveTrain = new RobotDrive(3, 2, 4, 5);
        RobotMap.drive = new Joystick(0);
        Drive.arcadeDrive(0, 0, speedBoost);
        RobotMap.hopper = new Talon(0);
        RobotMap.shooter = new Talon(1);
        turn = 0;
        move = 0;
        //hopper = 0;
        //shooter = 0;
        CameraServer camera = CameraServer.getInstance();
        camera.startAutomaticCapture("cam0");
    }
    

    public void autonomousInit() {
    	autonomousCommand = (Command) chooser.getSelected();
    	autonomousCommand.start();
    }


    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        turn = RobotMap.drive.getRawAxis(2);
        move = RobotMap.drive.getRawAxis(1);
        shooterMultiplier = RobotMap.drive.getRawAxis(3);
        
        shoot = RobotMap.drive.getRawButton(0);
        speedBoost = RobotMap.drive.getRawButton(1);
        
        Drive.arcadeDrive(move, turn, speedBoost);
        
        //hopper = RobotMap.drive.getRawAxis(3);
        //RobotMap.hopper.set(hopper*-1);
        shooter = RobotMap.drive.getRawAxis(2);
        
        if(shoot) {
        	RobotMap.shooter.set(shooter*shooterMultiplier);
        }
    }
    

    public void testPeriodic() {
    
    }
    
}
