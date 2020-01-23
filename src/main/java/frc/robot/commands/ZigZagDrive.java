/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import static frc.robot.RobotContainer.driveSub;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ZigZagDrive extends SequentialCommandGroup {
  /**
   * Creates a new ZigZag.
   */
  public ZigZagDrive() {

    addCommands(

     new AutoDriveTurn(45, driveSub),
     new AutoDriveFoward(5000, driveSub), 
     new AutoDriveTurn(360-45, driveSub), 
     new AutoDriveFoward(5000, driveSub)

    );
    

  }
}
