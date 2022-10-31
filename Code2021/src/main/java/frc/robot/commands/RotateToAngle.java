/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import static frc.robot.Constants.PID_CONST.*;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.TController;

public class RotateToAngle extends CommandBase {
  private final Drivebase m_drivebase;
  private final Gyro m_gyro;
  private final TController m_TController;
  private double x;
  public RotateToAngle(Drivebase drivebase, double angle) {
    m_drivebase = drivebase;
    m_gyro = Gyro.getInstance();
    m_TController = TController.getInstance();
    x = angle;
    m_TController.setSetpoint(x);
    m_TController.enableContinuousInput(-180, 180);
    m_TController.setIntegratorRange(-10, 1);
    m_TController.setTolerance();
    addRequirements(m_gyro);
    addRequirements(m_drivebase);
    addRequirements(m_TController);
  }

  @Override
  public void initialize() {
    m_TController.reset();
    m_gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("start", true);
    SmartDashboard.putNumber("angle", m_gyro.getYaw());
    double speed = m_TController.calculate(m_gyro.getYaw()); // get speed
    speed += Math.signum(speed) * 0.1; // lower bound
    speed = Math.min(0.6, Math.max(-0.6, speed)); // upper bound
    m_drivebase.drive(-speed, speed); // actual driving mechanism
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.drive(0, 0);
    SmartDashboard.putBoolean("start", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_TController.atSetpoint();
  }
}
