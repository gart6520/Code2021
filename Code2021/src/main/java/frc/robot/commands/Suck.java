// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sucker;

public class Suck extends CommandBase {
  private final Sucker m_sucker;
  double speed;
  public Suck(Sucker sucker, double speed) {
    m_sucker = sucker;
    this.speed = speed;
    addRequirements(m_sucker);
  }

  // Called when the command is initially scheduled.
@Override
  public void initialize() {
   
    m_sucker.suck(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_sucker.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
