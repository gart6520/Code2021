// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LIDAR extends SubsystemBase {
  private static final int CALIBRATION_OFFSET = -18;

  private Counter counter;
  private int printedWarningCount = 5;

  /** Creates a new LIDAR. */
  public LIDAR() {
    counter = new Counter(6);
    counter.setMaxPeriod(1.0);
    // Configure for measuring rising to falling pulses
    counter.setSemiPeriodMode(true);
    counter.reset();
  }

  public double getDistance() {
    /*
     * If we haven't seen the first rising to falling pulse, then we have no
     * measurement. This happens when there is no LIDAR-Lite plugged in, btw.
     */
    if (counter.get() < 1) {
      if (printedWarningCount-- > 0) {
        System.out.println("LidarLitePWM: waiting for distance measurement");
      }
      return 0;
    }
    /*
     * getPeriod returns time in seconds. The hardware resolution is microseconds.
     * The LIDAR-Lite unit sends a high signal for 10 microseconds per cm of
     * distance.
     */
    double cm = (counter.getPeriod() * 1000000.0 / 10.0) + CALIBRATION_OFFSET;
    return cm;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
// j gay