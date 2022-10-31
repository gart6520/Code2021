// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class AutoNav extends CommandBase {
  FileInputStream reader;
  double[][] speeds;
  int index = 0;
  private final Drivebase drivebase;
  public AutoNav(Drivebase drivebase) {
    this.drivebase = drivebase;
    addRequirements(drivebase);
   //
  

  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    index = 0;
    try {
      reader = new FileInputStream("home/lvuser/path.txt");
      ByteBuffer bytes = ByteBuffer.wrap(reader.readAllBytes());
      speeds = new double[bytes.array().length / 16][2];
      for (int i = 0; i < speeds.length; i++) {
        speeds[i] = new double[]{bytes.getDouble(), bytes.getDouble()};
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      double[] speed = speeds[index];
      index++;
    drivebase.drive(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivebase.drive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return index < speeds.length;
  }
}
