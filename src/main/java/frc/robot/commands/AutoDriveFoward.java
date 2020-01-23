/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSub;
import static frc.robot.subsystems.DriveSub.l1;
import static frc.robot.subsystems.DriveSub.l2;
import static frc.robot.subsystems.DriveSub.r1;
import static frc.robot.subsystems.DriveSub.r2;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoDriveFoward extends CommandBase {
  public static final double Distance = 0;
/**
   * Creates a new AutoDriveFoward.
   */
  double distance;

  public AutoDriveFoward(final double distance, final DriveSub subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.distance = distance;
  }

  public AutoDriveFoward(final double distance) {
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {

    r1.getSensorCollection().setQuadraturePosition(0, 10);
    r2.getSensorCollection().setQuadraturePosition(0, 10);
    l1.getSensorCollection().setQuadraturePosition(0, 10);
    l2.getSensorCollection().setQuadraturePosition(0, 10);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    RobotContainer.driveSub.drive(-0.7, 0);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {

    RobotContainer.driveSub.drive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(r2.getSensorCollection().getQuadraturePosition() >= distance) {
      return true;
    } else {
      return false;}
  }
}
