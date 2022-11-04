// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import static edu.wpi.first.wpilibj.PS4Controller.Button;

// import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.commands.ABSORB;
import frc.robot.commands.BARF;
import frc.robot.commands.FONDLE;
import frc.robot.commands.LAUNCH;
import frc.robot.subsystems.BeltSystem;
// import frc.robot.commands.TurnToAngle;
// import frc.robot.Constants.DriveConstants;
//import frc.robot.Constants.OIConstants;
//import frc.robot.commands.TurnToAngle;
//import frc.robot.commands.TurnToAngleProfiled;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.ShooterSystem;
// import frc.robot.subsystems.ShooterSystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
//import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems
    Joystick m_driverController = new Joystick(0);
    private final DriveSubsystem m_robotDrive = new DriveSubsystem();
    private final ShooterSystem m_shooterSystem = new ShooterSystem();
    private final IntakeSubsytem m_intakeSubsytem = new IntakeSubsytem();
    private final BeltSystem m_beltSubsystem = new BeltSystem();
    private final ABSORB absorb = new ABSORB(m_intakeSubsytem, m_driverController);
    private final FONDLE fondle = new FONDLE(m_beltSubsystem, m_driverController);
    private final LAUNCH launch = new LAUNCH(m_shooterSystem,1);
    // The driver's controller
    // PS4Controller m_driverController = new
    // PS4Controller(OIConstants.kDriverControllerPort);
    JoystickButton button1 = new JoystickButton(m_driverController, 1);
    JoystickButton button2 = new JoystickButton(m_driverController, 2);
    JoystickButton button3 = new JoystickButton(m_driverController, 3);
    JoystickButton button4 = new JoystickButton(m_driverController, 4);
    JoystickButton button5 = new JoystickButton(m_driverController, 5);
   
    JoystickButton button6 = new JoystickButton(m_driverController, 6);
    // JoystickButton button7 = new JoystickButton(m_driverController, 7);
    // JoystickButton button8 = new JoystickButton(m_driverController, 8);
    // JoystickButton button9 = new JoystickButton(m_driverController, 9);
    // JoystickButton button10 = new JoystickButton(m_driverController, 10);
    // JoystickButton button11 = new JoystickButton(m_driverController, 11);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        // Set the default drive command to split-stick arcade drive
        m_robotDrive.setDefaultCommand(
                // A split-stick arcade command, with forward/backward controlled by the left
                // hand, and turning controlled by the right.
                new RunCommand(
                        () -> m_robotDrive.arcadeDrive(
                                -m_driverController.getRawAxis(1), m_driverController.getRawAxis(0)),
                        m_robotDrive));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
     * subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link PS4Controller}), and then passing
     * it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        
        /*
         * Drive at half speed when the right bumper is held
         * 
         * new JoystickButton(m_driverController, Button.kR1.value)
         * .whenPressed(() -> m_robotDrive.setMaxOutput(0.5))
         * .whenReleased(() -> m_robotDrive.setMaxOutput(1));
         * 
         * // Stabilize robot to drive straight with gyro when left bumper is held
         * new JoystickButton(m_driverController, Button.kL1.value)
         * .whenHeld(
         * new PIDCommand(
         * new PIDController(
         * DriveConstants.kStabilizationP,
         * DriveConstants.kStabilizationI,
         * DriveConstants.kStabilizationD),
         * // Close the loop on the turn rate
         * m_robotDrive::getTurnRate,
         * // Setpoint is 0
         * 0,
         * // Pipe the output to the turning controls
         * output -> m_robotDrive.arcadeDrive(-m_driverController.getLeftY(), output),
         * // Require the robot drive
         * m_robotDrive));
         */
        //button2.whenPressed(new TurnToAngle(90, m_robotDrive));
        button1.whenHeld(launch);
        button3.whenHeld(absorb);
        button4.whenPressed(new BARF(m_beltSubsystem, m_intakeSubsytem, 2500));
        button5.whenPressed(fondle);
        button6.cancelWhenPressed(fondle);
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // no auto
        return new InstantCommand();
    }
}
