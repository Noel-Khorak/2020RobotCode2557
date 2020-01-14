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

public class PIDHood extends CommandBase {

  PIDController pidController;
  private final double kP = 0;
  private final double kI = 0;
  private final double kD = 0;
  private final double tolerance = 0;

  private final double hoodHeight = 2;
  private final double gravity = -32.2;

  


  /**
   * Creates a new PIDHood.
   */
  public PIDHood(HoodSub subsystem) {
    // Use addRequirements () here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidController = new PIDController(multp, multi, multd);
    pidController.disableContinuousInput(); // if subsystem is rotational, or has a minimum and maximum at the same points, should enableContinuousInput();
    pidController.setTolerance(tolerance); // the deadband, or margin of error acceptable
    pidController.reset();

    private double distance;
    private final double a = 8.1875 - hoodHeight;
    double vel = Math.sqrt((-(Math.pow(d, 2) * q)/Math.pow(a, 2) +  2 * (gravity*Math.pow(d, 2) / 2) / a - 4*gravity*a) / 2);
    // private final double vel = Math.sqrt( (Math.sqrt( Math.pow(d, 2) * q *( Math.pow(d, 2) * q - 4 * a * r) ) / (Math.pow(a,2) - Math.pow(d, 2) * q)) - ( Math.pow(d, 2) * q) / (Math.pow(a, 2)) + ((2 * r) / (a)) - 2 * q) / Math.sqrt(2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
