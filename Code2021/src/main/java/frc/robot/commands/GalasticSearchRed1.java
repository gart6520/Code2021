// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Opener;
import frc.robot.subsystems.Sucker;
import frc.robot.commands.Suck;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GalasticSearchRed1 extends SequentialCommandGroup {

  /** Creates a new Autonomous. */
  public GalasticSearchRed1(Drivebase drivebase, Opener opener) {
    super(parallel(new Open(opener, 0.5).withTimeout(1), new Run(drivebase, 1, 1).withTimeout(0.6)),
        new Run(drivebase, 0.4, 0.4).withTimeout(1.6), new Run(drivebase, 0, 0).withTimeout(0.5),
        new RotateToAngle(drivebase, -90).withTimeout(1.5), new Run(drivebase, 0.6, 0.6).withTimeout(1.4),
        new RotateToAngle(drivebase, 70).withTimeout(1.5), new Run(drivebase, 1, 1).withTimeout(1)

    );

  }
}
