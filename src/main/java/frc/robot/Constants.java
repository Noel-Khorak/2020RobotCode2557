/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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

    public static WPI_TalonSRX basicMotor;
        
    public static WPI_TalonSRX frontLeft;
    public static WPI_TalonSRX frontRight;
    public static WPI_TalonSRX backLeft;
    public static WPI_TalonSRX backRight;
    
    public static speedControllerGroup left;
    public static speedControllerGroup right;
    
    public static DifferentialDrive drivetrain; 
    
    public static void init(){
        
        basicMotor = new WPI_TalonSRX(0);
        
        frontLeft = new WPI_TalonSRX(1);
        frontRight = new WPI_TalonSRX(3);
        backLeft = new WPI_TalonSRX(0);
        backRight = new WPI_TalonSRX(2);
        
        left = new speedControllerGroup(frontLeft, backLeft);
        right = new speedControllerGroup(frontRight, backRight);
        drivetrain = new DifferentialDrive(left, right):

        Joystick joystick = new Joystick(0);
        
    // public static final AnalogInput enc = new AnalogInput(0);
    // public static final AnalogEncoder encode = new AnalogEncoder(enc);

}
