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

public class Hood extends SubsystemBase {
  public WPI_TalonSRX Hood = new WPI_TalonSRX(HOOD_CAN);
  public WPI_VictorSPX HoodR = new WPI_VictorSPX(6);

  public Hood() {
    // HoodR.follow(Hood);
    // HoodR.setInverted(true);

  }

  public void Angle(double a) {
    HoodR.set(a);
  }

  public void stop() {
    Hood.stopMotor();
  }

  public double getAngle() {
    return Hood.getSensorCollection().getQuadraturePosition();
  }
}
