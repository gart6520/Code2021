// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Hood;
import frc.robot.subsystems.WheelOfDoom;

public class AngleUp extends CommandBase {
  private final Hood m_hood;
  private double x;
  private double a;
  private double b;
  private double spd;

  public AngleUp(Hood hood, double x) {
    m_hood = hood;
    addRequirements(m_hood);
    spd = x;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_hood.Angle(0.2);
    a = m_hood.getAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    b = m_hood.getAngle();
    SmartDashboard.putNumber("Angle", b - a / 4096.0);
    // if (x > 0) {
    // while (b - a < x * 4096) {
    // m_hood.AngleUp();
    // }
    // } else {
    // while (b - a > x * 4096) {
    // m_hood.AngleDown();
    // }
    // if (b - a == x * 4096) {m_hood.stop();}
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_hood.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return false;
  }
}