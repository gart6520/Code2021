// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import static frc.robot.Constants.DRIVE_CONST.*;
import static frc.robot.Constants.STICK_CONST.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Opener extends SubsystemBase {

  public WPI_VictorSPX Opener = new WPI_VictorSPX(OPEN_CAN);

  public void Open(double x) {
    Opener.set(x);
  }

  public void stop() {
    Opener.stopMotor();
  }
  
}
