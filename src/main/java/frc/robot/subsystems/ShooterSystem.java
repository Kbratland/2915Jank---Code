package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSystem extends SubsystemBase {
    private final PWMSparkMax shooterNeo = new PWMSparkMax(9);
    Encoder encoder = new Encoder(0, 1);

    public void resetEncoders() {
        encoder.reset();
    }

}
