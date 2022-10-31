// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.TController;

public class GoStraight extends CommandBase {
  private final Drivebase m_drivebase;
  private final Gyro m_gyro;
  private final TController m_TController;
  private double x;

  public GoStraight(Drivebase drivebase, double speed) {
    m_drivebase = drivebase;
    m_gyro = Gyro.getInstance();
    m_TController = TController.getInstance();
    x = speed;
    addRequirements(m_gyro);
    addRequirements(m_drivebase);
    addRequirements(m_TController);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_TController.reset();
    m_gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double error = m_gyro.getYaw() * 0.05;
    SmartDashboard.putNumber("ahrs", m_gyro.getYaw());
    SmartDashboard.putNumber("error", error);
    m_drivebase.drive(x + error, x - error);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
