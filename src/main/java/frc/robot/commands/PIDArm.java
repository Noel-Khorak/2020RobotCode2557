/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.ArmSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class PIDArm extends PIDCommand {
  /**
   * Creates a new PIDArm.
   */

   double setpoint;
   double deadBand;
  public PIDArm(ArmSubsystem subsystem, double setpoint, double deadBand) {
    super(
        // The controller that the command will use
        new PIDController(1.1, 0, 0),
        // This should return the measurement
        () -> ArmSubsystem.arm1.getSensorCollection().getQuadraturePosition(),
        // This should return the setpoint (can also be a constant)
        () -> 1000,
        // This uses the output
        output -> {
          // Use the output here
          ArmSubsystem.moveArm(output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    this.setpoint = setpoint;
    this.deadBand = deadBand;
    
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(ArmSubsystem.arm1.getSensorCollection().getQuadraturePosition() - setpoint) > deadBand) {
      return false;
    } else {
      return true;
    }
  }
}
