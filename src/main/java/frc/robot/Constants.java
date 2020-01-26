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

private final I2C.Port i2cPortMXP = I2C.Port.kMXP;
private final I2C.Port i2cPortRoboRio = I2C.Port.kOnboard;

public final ColorSensorV3 r_colorSensor = new ColorSensorV3(i2cPortMXP);
public final ColorSensorV3 l_colorSensor = new ColorSensorV3(i2cPortRoboRio);

public final static ColorMatch l_colorMatcher = new ColorMatch();
public final static ColorMatch r_colorMatcher = new ColorMatch();

public final static Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
public final static Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
public final static Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
public final static Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

public static Color l_sensorColor = l_colorSensor.getColor();
public static Color r_sensorColor = r_colorSensor.getColor();

public static ColorMatchResult l_colorResult = l_colorMatcher.matchClosestColor(l_sensorColor);
public static ColorMatchResult r_colorResult = r_colorMatcher.matchClosestColor(r_sensorColor);

public static AnalogInput ultraSonic = new AnalogInput();

public Color l_sensorColor = l_colorSensor.getColor();
public Color r_sensorColor = r_colorSensor.getColor();

public static void init() {

    l_colorMatch.addColorMatch(kRedTarget);
    l_colorMatch.addColorMatch(kGreenTarget);
    l_colorMatch.addColorMatch(kBlueTarget);
    l_colorMatch.addColorMatch(kYellowTarget);
    r_colorMatch.addColorMatch(kRedTarget);
    r_colorMatch.addColorMatch(kGreenTarget);
    r_colorMatch.addColorMatch(kBlueTarget);
    r_colorMatch.addColorMatch(kYellowTarget);

}

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
