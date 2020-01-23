/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSub extends SubsystemBase {
  /**
   * Creates a new DriveSub.
   */
  public DriveSub() {

  }

  public static final WPI_TalonSRX r1 = new WPI_TalonSRX(3);
  public static final WPI_TalonSRX r2 = new WPI_TalonSRX(2);
  public static final WPI_TalonSRX l1 = new WPI_TalonSRX(1);
  public final static WPI_TalonSRX l2 = new WPI_TalonSRX(0);
  public static final SpeedControllerGroup l = new SpeedControllerGroup(l1, l2);
  public static final SpeedControllerGroup r = new SpeedControllerGroup(r1, r2);
  public final DifferentialDrive driveTrain = new DifferentialDrive(l, r);

  public static final AHRS navx = new AHRS(SPI.Port.kMXP);

  public void drive(double fwd, double rot) {
    
    // DriveSub.drive(fwd, rot);
    driveTrain.arcadeDrive(fwd, rot);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
