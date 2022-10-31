// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.IOException;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class Crash extends CommandBase {
  public Crash() {
      //
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize(){
    ((Crash)null).end(true); 
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //
  }

  // Called once the command ends or is interrupted.
  

  // Returns true when the command should end.
  
}