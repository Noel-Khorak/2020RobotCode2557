/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSub;

public class AutoDriveTurn extends CommandBase {
/**
   * Creates a new AutoDriveRotate.
   */

  double angle;

  public AutoDriveTurn(double angle, DriveSub subsystem) {
    
    this.angle = angle;
    
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(subsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    DriveSub.navx.reset();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (angle >= 0) {

      RobotContainer.driveSub.drive(0, 0.6);

    }else if (angle <= 0) {

      RobotContainer.driveSub.drive(0, -0.6);

    }

    SmartDashboard.putNumber("Angle Setpoint: ", angle);
    SmartDashboard.putNumber("Current Angle: ", DriveSub.navx.getAngle());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    RobotContainer.driveSub.drive(0, 0);
  }

  // Returns true when the command should end.                                        
  @Override
  public boolean isFinished() {


    if(Math.abs(DriveSub.navx.getAngle()) >= angle){
      return true;
    }else{
      return false;
    }
  }
}
