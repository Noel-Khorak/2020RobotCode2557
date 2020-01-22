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

I2C.Port i2cPortRoboRio = I2C.Port.kOnboard;
colorSensorV3 l_colorSensor = new ColorSensorV3(i2cPortRoboRio);

Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
Color kRedTarget = ColorMatch.makeColor(0.429, 0.143, 0.143);
Color kGreenTarget = ColorMatch.makeColor();
Color kYellowTarget = ColorMatch.makeColor();

Color colorSeen = l.colorSensor.getColor();

ColorMatchResult <RandomName> = <SensorName>.matchClosestColor(WhatsBeingDetected);

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

    public static WPI_TalonSRX basicMotor = new WPI_TalonSRX(0);
        
    public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(1);
    public static WPI_TalonSRX frontRight = new WPI_TalonSRX(3);
    public static WPI_TalonSRX backLeft = new WPI_TalonSRX(0);
    public static WPI_TalonSRX backRight = new WPI_TalonSRX(2);
    
    public static speedControllerGroup left = new speedControllerGroup(frontLeft, backLeft); 
    public static speedControllerGroup right = new speedControllerGroup(frontRight, backRight);
    
    public static DifferentialDrive drivetrain  = new DifferentialDrive(left, right):

    Joystick joystick  = new Joystick(0); 
    // public static final AnalogInput enc = new AnalogInput(0);
    // public static final AnalogEncoder encode = new AnalogEncoder(enc);
    
    
}
