// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Opener;

public class Open extends CommandBase {
  private double x;
  private final Opener m_opener;
  public Open(Opener opener, double spd) {
    m_opener = opener;
    x=spd;
    addRequirements(m_opener);
  }

  @Override
  public void initialize() {
    m_opener.Open(x);
  }
  @Override
  public void execute() {
//
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  m_opener.stop();
}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
