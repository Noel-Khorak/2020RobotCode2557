/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSub;

public class PIDTurret extends CommandBase {

  static PIDController pidController;
  private static final double kP = 0;
  private static final double kI = 0;
  private static final double kD = 0;
  private static final double tolerance = 10;

  static double x;
  static double a0;
  static double a1;
  static double valid;
  static NetworkTable table;
  static NetworkTableEntry ta0;
  static NetworkTableEntry ta1;
  static NetworkTableEntry tx;
  static NetworkTableEntry tv;
  private static final double setpoint = 0;




  /**
   * Creates a new PIDTurret.
   */
  public PIDTurret(TurretSub subsystem) {
    table = NetworkTableInstance.getDefault().getTable("limelight");

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidController = new PIDController(kP, kI, kD);
    pidController.disableContinuousInput();
    pidController.setTolerance(tolerance); 
    pidController.reset();
  }

  public static void getCamData() {
	  tx = table.getEntry("tx");
    ta0 = table.getEntry("ta0");
    ta1 = table.getEntry("ta1");
    tv = table.getEntry("tv");


		//read values periodically
    x = tx.getDouble(0.0);
    a0 = ta0.getDouble(0.0);
    a1 = ta1.getDouble(0.0);
    valid = tv.getDouble(0.0);
 }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    getCamData();
    double output = pidController.calculate(x, setpoint);
    TurretSub.rotate(output);
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
