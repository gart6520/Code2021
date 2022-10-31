// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.controller.PIDController;
import static frc.robot.Constants.PID_CONST.*;

import javax.security.auth.x500.X500Principal;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class TController extends SubsystemBase {
  private PIDController turnController;
  private TController() 
  {
    turnController = new PIDController(kP, kI, kD);
  }

  private static TController tcontroller = null;

  public static TController getInstance()
  {
    if (tcontroller == null)
    {
      tcontroller = new TController();
    }
    return tcontroller;
  }
  public void setSetpoint(double x) {
    turnController.setSetpoint(x);
  }
  public void reset() {
    turnController.reset();
  }
  public void enableContinuousInput(double a, double b) {
    turnController.enableContinuousInput(a, b);
  }
  public void setIntegratorRange(double m, double n) {
    turnController.setIntegratorRange(m, n);
  }
  public void setTolerance() {
    turnController.setTolerance(kToleranceDegrees, kToleranceAngularVelocity);
  }
  public double calculate(double c) {
    return turnController.calculate(c);
  }
  public boolean atSetpoint() {
    return turnController.atSetpoint();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
