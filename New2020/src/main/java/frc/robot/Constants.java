/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */

public final class Constants {
    public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(0);
    public static WPI_TalonSRX backLeft = new WPI_TalonSRX(0);
    public static WPI_TalonSRX frontRight = new WPI_TalonSRX(0);
    public static WPI_TalonSRX backRight = new WPI_TalonSRX(0);
    public static SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
    public static SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
    public static DifferentialDrive diffDrive = new DifferentialDrive(left, right);
}
