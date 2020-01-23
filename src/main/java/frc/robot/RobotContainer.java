/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.AutoDriveFoward;
import frc.robot.commands.AutoDriveTurn;
import frc.robot.commands.PIDCommand;
import frc.robot.commands.ZigZagDrive;
import frc.robot.subsystems.DriveSub;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  public static final DriveSub driveSub = new DriveSub();

  public static final Joystick stick = new Joystick(0);

  public static final AutoDriveFoward autoDriveFoward = new AutoDriveFoward(1000, driveSub);
  public static final AutoDriveTurn autoDriveTurn = new AutoDriveTurn(30, driveSub);
  public static final ZigZagDrive zigZagDrive = new ZigZagDrive();

  public static final PIDCommand pidCommand = new PIDCommand(10000);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driveSub.setDefaultCommand(new RunCommand(() -> driveSub.drive(stick.getRawAxis(1), stick.getRawAxis(5)), driveSub));

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous

    return pidCommand;

  }
}
