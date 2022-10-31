package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.WheelOfDoom;

public class Run extends CommandBase {
  private final Drivebase m_drivebase;
  private double x;
  private double y;
  public Run(Drivebase drivebase, double spd1, double spd2) {
    m_drivebase = drivebase;
    x = spd1;
    y = spd2;
    addRequirements(m_drivebase);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
//
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivebase.drive(-x,-y);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.drive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
