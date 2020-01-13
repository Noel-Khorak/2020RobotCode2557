/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.SpinMotor;


public class PID extends CommandBase {
  PIDController pidController;
  final	double multp = 0;
	final double multi = 0;
  final double multd = 0;
  final double tolerance = 0;
  final double setpoint = 0;
  double measurementSource;
  final SpinMotor subsystem;

 public PID(SpinMotor subsystem) {
   this.subsystem = subsystem;
   addRequirements(subsystem);
 }


 // Called when the command is initially scheduled.
 @Override
 public void initialize() {
   pidController = new PIDController(multp, multi, multd);
   pidController.disableContinuousInput(); // if subsystem is rotational, or has a minimum and maximum at the same points, should enableContinuousInput();
   pidController.setTolerance(tolerance); // the deadband, or margin of error acceptable
   pidController.reset(); // resets error and i coefficient
 }


 // Called every time the scheduler runs while the command is scheduled.
 @Override
 public void execute() {  
   
   double output = pidController.calculate(measurementSource, setpoint);

 }


 // Called once the command ends or is interrupted.
 @Override
 public void end(boolean interrupted) {
 }


 // Returns true when the command should end.
 @Override
 public boolean isFinished() {
   return pidController.atSetpoint(); //returns a boolean value denoting whether the error is within tolerance or in other words, at the setpoint
 }
}

