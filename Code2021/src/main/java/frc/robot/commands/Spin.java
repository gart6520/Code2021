// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfDoom;

public class Spin extends CommandBase {
  private final WheelOfDoom m_WOD;
  private double x;
  public Spin(WheelOfDoom wod, double spd) {
    m_WOD = wod;
    x = spd;
    addRequirements(m_WOD);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_WOD.spin(x);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_WOD.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
