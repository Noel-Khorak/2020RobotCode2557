/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HoodSub;

public class PIDFlywheel extends CommandBase {
  
  private static PIDController pidController;
  private static final double kP = 0;
  private static final double kI = 0;
  private static final double kD = 0;
  private static final double tolerance = 1;
  public double setpoint;
  private double output;

  /**
   * Creates a new PIDFlywheel.
   */
  public PIDFlywheel(double setpoint) {
    this.setpoint = setpoint;
    pidController = new PIDController(kP, kI, kD);
    pidController.reset();
    pidController.disableContinuousInput();
    pidController.setTolerance(tolerance);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    output = pidController.calculate(HoodSub.getFlywheelSpeed(), setpoint);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
