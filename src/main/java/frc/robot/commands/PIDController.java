/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class PIDController extends CommandBase {
  
  PIDController pidController;
  boolean done = false; 
  double factor = 0.000001;
  double driveSetPoint;

  public void PIDCommand(double driveSetpoint) {
  
    this.driveSetPoint = driveSetpoint;
    addRequirements(RobotContainer.driveSub);
  }

  public PIDController() {

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    pidController = new PIDController();
    pidController.disableContinuousInput();
    pidController.setTolerance(100);
    pidController.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double output = pidController.calculate(l2.getSensor().getQuadraturePosition(), driveSetPoint);
    Robot.driveSub.autoDrive(output, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    Robot.driveSub.autoDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return pidController.atSetpoint;
  }
}
