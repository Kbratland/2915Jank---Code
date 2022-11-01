package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class IntakeSubsytem extends SubsystemBase {
    private final WPI_TalonSRX ballIntake = new WPI_TalonSRX (DriveConstants.kShooterPort);
    // Encoder encoder = new Encoder(0, 1);

    // public void resetEncoders() {
    // encoder.reset();
    // }

    public void SuckBalls() {
        ballIntake.set(0.5);
    }
}