package org.usfirst.frc.team1710.robot;

import edu.wpi.first.wpilibj.Joystick;
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class RobotMap {
	public static RobotDrive driveTrain;
	public static Joystick drive, mech;
	public static Talon hopper, shooter;
	public static AHRS navx;
}
