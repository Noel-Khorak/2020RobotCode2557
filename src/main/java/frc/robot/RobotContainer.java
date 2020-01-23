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
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ZigZagDrive;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.SpinMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final DriveSub driveSub = new DriveSub();
  public static final SpinMotor spinSub = new SpinMotor();

  public static final ZigZagDrive zigZagDrive = new ZigZagDrive();
  // public static final DriveCommand driveCommand = new DriveCommand(driveSub);
  // public static final PIDArm armCommand = new PIDArm(armSub, 1000, 250);

  public static final Joystick stick = new Joystick(0);
  public static final JoystickButton dA = new JoystickButton(stick, 1);
  public static final JoystickButton b = new JoystickButton(stick, 3);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // spinSub.setDefaultCommand(new RunCommand(() -> SpinMotor.spin(1), spinSub));
    driveSub.setDefaultCommand(new DriveCommand(driveSub));


    // Configure the button bindings

    configureButtonBindings();

    

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    dA.whenPressed(() -> driveSub.shift(), driveSub);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return zigZagDrive;
  }
}
