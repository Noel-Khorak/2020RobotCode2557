/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSub extends SubsystemBase {
  public static final int gearWhenForward = 1;
  public static final int gearWhenReverse = 2;
  public static final double ratioGear1 = 0;
  public static final double ratioGear2 = 0;
  public static final double eTicksPerRev = 0;
  public static final double limitRotSpdGear1 = 0;

  public static final DoubleSolenoid ds = new DoubleSolenoid(0, 1);
  public static final WPI_TalonSRX l1 = new WPI_TalonSRX(1);
  public static final WPI_TalonSRX l2 = new WPI_TalonSRX(0);
  public static final WPI_TalonSRX r1 = new WPI_TalonSRX(3);
  public static final WPI_TalonSRX r2 = new WPI_TalonSRX(2);
  public static final SpeedControllerGroup l = new SpeedControllerGroup(l1, l2);
  public static final SpeedControllerGroup r = new SpeedControllerGroup(r1, r2);
  public static final DifferentialDrive driveTrain = new DifferentialDrive(l, r);

  /**
   * Creates a new DriveSub.
   */
  public DriveSub() {
  }

  public void drive(double fwd, double rot){
    driveTrain.arcadeDrive(fwd, rot);
  }

  public void shift() {
    if (ds.get() == Value.kForward) {
      ds.set(Value.kReverse);
    } else if(ds.get() == Value.kReverse) {
      ds.set(Value.kForward);
    }
    
  }

  public int getCurrentGear() {
    if (ds.get() == Value.kForward) {
      return gearWhenForward;
    } else if(ds.get() == Value.kReverse) {
      return gearWhenReverse;
    }
    return 0;
  }

  // returns rotation speed of wheel in rotations per 100ms
  public double getRotationSpeed (double currentGear) {
    if (currentGear == 1) {
      return l1.getSensorCollection().getQuadratureVelocity()/eTicksPerRev * ratioGear1;
    } else if (currentGear == 2) {
      return l1.getSensorCollection().getQuadratureVelocity()/eTicksPerRev * ratioGear2;
    }
    return 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}