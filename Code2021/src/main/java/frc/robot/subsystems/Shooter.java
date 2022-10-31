// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.DRIVE_CONST.*;

import static frc.robot.Constants.STICK_CONST.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Shooter extends SubsystemBase {

  public WPI_TalonSRX shooterMaster = new WPI_TalonSRX(SHOOTER_MASTER_CAN);
  public WPI_TalonSRX shooterFOLLOW = new WPI_TalonSRX(SHOOTER_FOLLOW_CAN);
  
  public Shooter() {
    shooterMaster.setInverted(true);
    shooterFOLLOW.follow(shooterMaster);
    shooterFOLLOW.setNeutralMode(NeutralMode.Brake);
    shooterMaster.setNeutralMode(NeutralMode.Brake);
  }

  public void shoot() {
    shooterMaster.set(1);
  }

  public void stop() {
    shooterMaster.stopMotor();
  }
 


}
