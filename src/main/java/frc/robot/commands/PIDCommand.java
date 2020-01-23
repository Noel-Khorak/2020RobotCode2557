/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSub;

public class PIDCommand extends CommandBase {
  PIDController pidController;
  boolean done = false;
  double factor = 0.000001; // 10^-6+4+2
  double driveSetpoint;

  public PIDCommand(double driveSetpoint) {
    this.driveSetpoint = driveSetpoint;
    addRequirements(RobotContainer.driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidController = new PIDController(0.0003, 0, 0);
    pidController.disableContinuousInput();
    pidController.setTolerance(50);
    pidController.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double output = pidController.calculate(DriveSub.l2.getSensorCollection().getQuadraturePosition(), driveSetpoint);

    RobotContainer.driveSub.drive(-output, 0);
    // System.out.println("PID out put  " + -output + Constants.pidarmStall*Math.sin(enc));

    // System.out.println("ARM ENCODER" + Constants.armRight.getSensorCollection().getQuadraturePosition());

    // System.out.print("AT SETPOINT   "  + pidController.atSetpoint());

    // System.out.println("     Arm encoder #   "  + -Constants.armRight.getSensorCollection().getQuadraturePosition() + " Setpoint    " + pidController.getSetpoint());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSub.driveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return pidController.atSetpoint();
  }
}