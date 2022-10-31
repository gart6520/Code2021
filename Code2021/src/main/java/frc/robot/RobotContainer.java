/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AngleUp;
import frc.robot.commands.AutoNav;
import frc.robot.commands.Crash;
import frc.robot.commands.GalasticSearchRed2;
import frc.robot.commands.GoStraight;
import frc.robot.commands.Load;
import frc.robot.commands.Open;
import frc.robot.commands.Shoot;
import frc.robot.commands.Spin;
import frc.robot.commands.Suck;
// import frc.robot.commands.PistonExtend;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.NetworkTableQuery;
import frc.robot.subsystems.Opener;
// import frc.robot.subsystems.Piston;
import frc.robot.subsystems.Sucker;
import frc.robot.subsystems.LIDAR;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.WheelOfDoom;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

import static frc.robot.Constants.STICK_CONST.*;
import java.time.Year;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Drivebase drivebase = new Drivebase();
  public final Opener opener = new Opener();
  private final GalasticSearchRed2 m_autoCommand = new GalasticSearchRed2(drivebase, opener);
  public static Joystick xbox = new Joystick(1);
  public static Joystick logitech = new Joystick(0);
  public final Shooter shooter = new Shooter();
  public static final LIDAR lidar = new LIDAR();
  public final Sucker sucker = new Sucker();
  public final WheelOfDoom WOD = new WheelOfDoom();
  public final NetworkTableQuery mysql = new NetworkTableQuery();
  // public final Piston piston = new Piston();
  public final Loader loader = new Loader();
  public final Hood hood = new Hood();
  Command shoot = new Shoot(shooter);

  Command suck = new Suck(sucker, 0.6);
  Command spit = new Suck(sucker, -0.9);
  Command spin = new Spin(WOD, 0.3);
  Command Open = new Open(opener, 0.5);
  Command Close = new Open(opener, -0.5);
  Command AngleUp = new AngleUp(hood, 0.4);
  Command AngleDown = new AngleUp(hood, -0.3);
  // Command PistonExtend = new PistonExtend(piston);
  Command Load = new Load(loader, 0.6);
  Command Unload = new Load(loader, -0.6);
  Command spinR = new Spin(WOD, -0.3);
  Command GoUp = new GoStraight(drivebase, -0.5);
  Command GoDown = new GoStraight(drivebase, 0.5);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(logitech, L1).whileActiveOnce(suck);
    new JoystickButton(logitech, R1).whileActiveOnce(spit);
    new JoystickButton(xbox, R1).whileActiveOnce(shoot);
    new JoystickButton(logitech, GREEN).whileActiveOnce(Open);
    new JoystickButton(logitech, BLUE).whileActiveOnce(spin);
    new JoystickButton(xbox, YELLOW).whileActiveOnce(AngleUp);
    new JoystickButton(xbox, RED).whileActiveOnce(AngleDown);
    new JoystickButton(xbox, BLUE).whileActiveOnce(Unload);
    new JoystickButton(logitech, YELLOW).whileActiveOnce(Close);
    new JoystickButton(xbox, L1).whileActiveOnce(Load);
    new JoystickButton(logitech, RED).whileActiveOnce(spinR);
    new JoystickButton(xbox, 9).whenPressed(new Crash());
    new POVButton(logitech, 0).whileActiveOnce(GoUp);
    new POVButton(logitech, 180).whileActiveOnce(GoDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}