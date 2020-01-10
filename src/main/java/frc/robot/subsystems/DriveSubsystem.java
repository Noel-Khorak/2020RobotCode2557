/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  
  private static final int GEAR_FORWARD = 1;
  private static final int GEAR_REVERSE = 2;
  private static final double ratioGear1 = 0;
  private static final double ratioGear2 = 0;
  private static final double eTickPerRev = 0;

  public DriveSubsystem() {

  }
  
  public static void driveBase(double speed, double rotation){
    Constants.diffDrive.arcadeDrive(speed, rotation);
  }

  public static void shiftGear() {
    if(Constants.doubleSol.get() == Value.kForward){
      Constants.doubleSol.set(Value.kReverse);
    }else if(Constants.doubleSol.get() == Value.kReverse) {
      Constants.doubleSol.set(Value.kForward);
    }
  }

  public static int getCurrentGear(){
    if(Constants.doubleSol.get() == Value.kForward){
      return GEAR_FORWARD;
    }else if(Constants.doubleSol.get() == Value.kReverse) {
      return GEAR_REVERSE;
    } else {
      return 0;
    }
  }

  public static double getRotationSpeed(double gearRatio){
    if(getCurrentGear() == 1){
      return Constants.frontL.getSensorCollection().getQuadratureVelocity()/eTickPerRev * ratioGear1;
    }else if(getCurrentGear() == 2){
      return Constants.frontL.getSensorCollection().getQuadratureVelocity()/eTickPerRev * ratioGear2;
    }
    return 0;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
