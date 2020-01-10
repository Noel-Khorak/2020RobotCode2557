/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

  public static final WPI_TalonSRX arm1 = new WPI_TalonSRX(7);
  public static final WPI_TalonSRX arm2 = new WPI_TalonSRX(8);
  /**
   * Creates a new ArmSubsystem.
   */
  public ArmSubsystem() {

  }

  public static void moveArm(double spd) {
    arm1.set(spd);
    arm2.set(-spd);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
