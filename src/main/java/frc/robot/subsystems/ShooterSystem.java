package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class ShooterSystem extends SubsystemBase {
    private final PWMSparkMax NeoShooter = new PWMSparkMax(DriveConstants.kShooterPort);
    // Encoder encoder = new Encoder(0, 1);

    // public void resetEncoders() {
    // encoder.reset();
    // }

    public void shoot() {
        NeoShooter.set(0.5);
    }
}
