// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.WheelOfDoom;

public class Load extends CommandBase {
  private final Loader m_loader;
  double speed;
  public Load(Loader loader,double speed) {
    this.speed = speed;
    m_loader = loader;
    addRequirements(m_loader);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_loader.load(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_loader.load(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
