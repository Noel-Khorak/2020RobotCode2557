/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinMotor;


public class PIDColorFinder extends CommandBase {
  PIDController pidController;
  final	double multp = 0;
	final double multi = 0;
  final double multd = 0;
  final double tolerance = 0;
  final double encoderMax = 100;
  final SpinMotor subsystem;
  double setpoint;
  String gameData;

 public PIDColorFinder(SpinMotor subsystem, String gameData) {
   this.subsystem = subsystem;
   this.gameData = gameData;
   addRequirements(subsystem);
 }


 // Called when the command is initially scheduled.
 @Override
 public void initialize() {
   pidController = new PIDController(multp, multi, multd);
   pidController.enableContinuousInput(0, encoderMax);
   pidController.setTolerance(tolerance); // the deadband, or margin of error acceptable
   pidController.reset(); // resets error and i coefficient

   if(gameData.length() > 0) {
     switch (gameData.charAt(0)) {
       case 'B' :
         //Blue case code
         break;
       case 'G' :
         //Green case code
         break;
       case 'R' :
         //Red case code
         break;
       case 'Y' :
         //Yellow case code
         break;
       default :
         //This is corrupt data
         break;
     }
   } else {
    SmartDashboard.putString("No game Data found", "sad");
  }
   
 }


 // Called every time the scheduler runs while the command is scheduled.
 @Override
 public void execute() {  
   
  double output = pidController.calculate(subsystem.motor1.getSensorCollection().getQuadraturePosition(), setpoint);
  SpinMotor.spin(output);
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

