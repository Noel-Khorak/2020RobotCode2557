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
    
    
    public static final WPI_TalonSRX frontL = new WPI_TalonSRX(1);
    public static final WPI_TalonSRX frontR = new WPI_TalonSRX(3);
    public static final WPI_TalonSRX backL = new WPI_TalonSRX(0);
    public static final WPI_TalonSRX backR = new WPI_TalonSRX(2);
    public static final DoubleSolenoid doubleSol = new DoubleSolenoid(1, 0);
  
    public static final SpeedControllerGroup left = new SpeedControllerGroup(frontL, backL);
    public static final SpeedControllerGroup right = new SpeedControllerGroup(frontR, backR);
    public static final DifferentialDrive diffDrive = new DifferentialDrive(left, right);
  
    // public static final AnalogInput enc = new AnalogInput(0);
    // public static final AnalogEncoder encode = new AnalogEncoder(enc);

}
