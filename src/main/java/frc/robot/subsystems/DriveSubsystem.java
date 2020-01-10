/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  public static final int REVERSE_GEAR = 1;
  public static final int FORWARD_GEAR = 2;
  public static final int TICKS_PER_REV = 1000;
  public static int frontLeftEncVal = Constants.frontLeft.getSensorCollection().getQuadratureVelocity();
  public static int frontRightEncVal = Constants.frontRight.getSensorCollection().getQuadratureVelocity();
  public static int backLeftEncVal = Constants.backLeft.getSensorCollection().getQuadratureVelocity();
  public static int backRightEncVal = Constants.backRight.getSensorCollection().getQuadratureVelocity();
  // private static final AnalogInput enc = new AnalogInput(0);
  // private static final AnalogEncoder encoder = new AnalogEncoder(enc);
  private static final DoubleSolenoid doubleSol = new DoubleSolenoid(0, 1);
  public DriveSubsystem() {

  }
  public static void drive(final double speed, final double rotation) {
    Constants.diffDrive.arcadeDrive(speed, rotation);
    
    // double encoderPos = encoder.get();
  }

  // changes current gear
  public static void shiftGear() {
    if (doubleSol.get() == Value.kForward) {
      doubleSol.set(Value.kReverse);
    } else if (doubleSol.get() == Value.kReverse) {
      doubleSol.set(Value.kForward);
    }
  }

  // returns current gear
  public static int getGear(){
    if (doubleSol.get() == Value.kForward) {
      return FORWARD_GEAR;
    } else if (doubleSol.get() == Value.kReverse) {
      return REVERSE_GEAR;
    } else {
      return 0;
    }
  }

  // returns the rotation speed of the wheel in rotations/100ms
  public static double getRotation() {
    SmartDashboard.putNumber("Encoder Value: ", frontLeftEncVal);
    if (getGear() == 1){
      return (frontLeftEncVal/TICKS_PER_REV) * Constants.GEAR_RATIO_1;
    } else if (getGear() == 2){
      return (frontLeftEncVal/TICKS_PER_REV) * Constants.GEAR_RATIO_2;
    } else {
      return 0.0;
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
