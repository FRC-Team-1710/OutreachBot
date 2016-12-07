
package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String lukeAuto = "Luke Auto";
    final String pennAuto = "Penn Auto";
    String autoSelected;
    SendableChooser chooser;
    double turn, move;
    Command autonomousCommand;

    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("Luke Auto", lukeAuto);
        chooser.addObject("Penn Auto", pennAuto);
        SmartDashboard.putData("Auto choices", chooser);
        RobotMap.driveTrain = new RobotDrive(3, 2, 4, 5);
        RobotMap.drive = new Joystick(0);
        Drive.arcadeDrive(0, 0);
        turn = 0;
        move = 0;
    }
    

    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
		System.out.println("Auto selected: " + autoSelected);
		if(autoSelected == lukeAuto) {
			autonomousCommand = new LukesAuto();
		} else if (autoSelected == pennAuto) {
			autonomousCommand = new PennsAuto();
		}
    }


    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        turn = RobotMap.drive.getRawAxis(4);
        move = RobotMap.drive.getRawAxis(1);
        Drive.arcadeDrive(move, turn);
    }

    public void testPeriodic() {
    
    }
    
}
