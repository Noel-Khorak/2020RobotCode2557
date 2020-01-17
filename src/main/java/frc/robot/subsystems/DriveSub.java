/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSub extends SubsystemBase {
  public static final int gearWhenForward = 1;
  public static final int gearWhenReverse = 2;
  public static final double ratioGear1 = 18.86;
  public static final double ratioGear2 = 6.45;
  public static final double eTicksPerRev = 0;
  public static final double limitRotSpdGear1 = 238; // rotations per minute

  public static final DoubleSolenoid dsL = new DoubleSolenoid(0, 1);
  public static final DoubleSolenoid dsR = new DoubleSolenoid(0, 2);
  public static final CANSparkMax l1 = new CANSparkMax(0, MotorType.kBrushless);
  public static final CANSparkMax l2 = new CANSparkMax(1, MotorType.kBrushless);
  public static final CANSparkMax r1 = new CANSparkMax(15, MotorType.kBrushless);
  public static final CANSparkMax r2 = new CANSparkMax(14, MotorType.kBrushless);
  public static final SpeedControllerGroup l = new SpeedControllerGroup(l1, l2);
  public static final SpeedControllerGroup r = new SpeedControllerGroup(r1, r2);
  public static final DifferentialDrive driveTrain = new DifferentialDrive(l, r);

  public static final CANEncoder encoder = l1.getEncoder();

  /**
   * Creates a new DriveSub.
   */
  public DriveSub() {
  }

  public void drive(double fwd, double rot){
    driveTrain.arcadeDrive(fwd, rot);
  }

  public void shift() {
    if (dsL.get() == Value.kForward) {
      dsL.set(Value.kReverse);
      dsR.set(Value.kForward);
    } else if(dsL.get() == Value.kReverse) {
      dsL.set(Value.kForward);
      dsR.set(Value.kForward);
    }
    
  }

  public int getCurrentGear() {
    if (dsL.get() == Value.kForward) {
      return gearWhenForward;
    } else if(dsL.get() == Value.kReverse) {
      return gearWhenReverse;
    }
    return 0;
  }

  // returns rotation speed of wheel in rotations per minute
  public double getRotationSpeed (double currentGear) {
    if (currentGear == 1) {
      return (encoder.getVelocity()/eTicksPerRev) / ratioGear1;
    } else if (currentGear == 2) {
      return (encoder.getVelocity()/eTicksPerRev) / ratioGear2;
    }
    return 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}