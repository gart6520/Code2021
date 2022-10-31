// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.DRIVE_CONST.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Loader extends SubsystemBase {
  public WPI_TalonSRX loader = new WPI_TalonSRX(LOADER_CAN);
  public Loader() {
    //
  }

  public void load(double speed) {
     loader.set(speed);
  }
  
}

