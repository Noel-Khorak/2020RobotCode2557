/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSub extends SubsystemBase {

  public static WPI_TalonSRX hoodMotor = new WPI_TalonSRX(3);
  public static WPI_TalonSRX flywheelMotor = new WPI_TalonSRX(5);
  private static final double encTicksPerRot = 0;

  /**
   * Creates a new HoodSub.
   */

  public HoodSub() {

  }

  public static void spinFlywheel(double speed) {
    flywheelMotor.set(speed);
  }

  // returns RPM of flywheel
  public static double getFlywheelSpeed() {
    return (flywheelMotor.getSensorCollection().getQuadratureVelocity() / encTicksPerRot) * 600;

  }

  public static void angleHood(double speed){
    hoodMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
