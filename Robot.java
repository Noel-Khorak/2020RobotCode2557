/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private final I2C.Port i2cPortRoboRio = I2C.Port.kOnboard;
  private final I2C.Port i2cPortMXP = I2C.Port.kMXP;

  private final ColorSensorV3 l_colorSensor = new ColorSensorV3(i2cPortRoboRio);
  private final ColorSensorV3 r_colorSensor = new ColorSensorV3(i2cPortMXP);

  private final ColorMatch l_colorMatcher = new ColorMatch();
  private final ColorMatch r_colorMatcher = new ColorMatch();

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    l_colorMatcher.addColorMatch(kBlueTarget);
    l_colorMatcher.addColorMatch(kGreenTarget);
    l_colorMatcher.addColorMatch(kRedTarget);
    l_colorMatcher.addColorMatch(kYellowTarget);

    r_colorMatcher.addColorMatch(kBlueTarget);
    r_colorMatcher.addColorMatch(kGreenTarget);
    r_colorMatcher.addColorMatch(kRedTarget);
    r_colorMatcher.addColorMatch(kYellowTarget);    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    Color detectedColorRio = l_colorSensor.getColor();
    Color detectedColorMXP = r_colorSensor.getColor();

    String colorStringRio;
    String colorStringMXP;
    ColorMatchResult lMatch = l_colorMatcher.matchClosestColor(detectedColorRio);
    ColorMatchResult rMatch = r_colorMatcher.matchClosestColor(detectedColorRio);

    if (lMatch.color == kBlueTarget) {
      colorStringRio = "Blue";
    } else if (lMatch.color == kRedTarget) {
      colorStringRio = "Red";
    } else if (lMatch.color == kGreenTarget) {
      colorStringRio = "Green";
    } else if (lMatch.color == kYellowTarget) {
      colorStringRio = "Yellow";
    } else {
      colorStringRio = "Unknown";
    }
    
    if (rMatch.color == kBlueTarget) {
      colorStringMXP = "Blue";
    } else if (rMatch.color == kRedTarget) {
      colorStringMXP = "Red";
    } else if (rMatch.color == kGreenTarget) {
      colorStringMXP = "Green";
    } else if (rMatch.color == kYellowTarget) {
      colorStringMXP = "Yellow";
    } else {
      colorStringMXP = "Unknown";
    }

    // double IR = m_colorSensor.getIR();

    SmartDashboard.putNumber("RioRed", detectedColorRio.red);
    SmartDashboard.putNumber("RioGreen", detectedColorRio.green);
    SmartDashboard.putNumber("RioBlue", detectedColorRio.blue);
    SmartDashboard.putNumber("MXPRed", detectedColorMXP.red);
    SmartDashboard.putNumber("MXPGreen", detectedColorMXP.green);
    SmartDashboard.putNumber("MXPBlue", detectedColorMXP.blue);
    SmartDashboard.putString("Rio Color", colorStringRio);
    SmartDashboard.putString("MXP Color", colorStringMXP);
    
    // SmartDashboard.putNumber("IR", IR);

    // int proximity = m_colorSensor.getProximity();

    // SmartDashboard.putNumber("Proximity", proximity);


  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    // SmartDashboard.putNumber("Red", )

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
