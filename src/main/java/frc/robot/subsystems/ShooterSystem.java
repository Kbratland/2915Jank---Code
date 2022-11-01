package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Encoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class ShooterSystem extends SubsystemBase {
    private final CANSparkMax neoShooter = new CANSparkMax(DriveConstants.kShooterPort, MotorType.kBrushless);
    public ShooterSystem() {
    }
    public void shoot() {
        neoShooter.set(1);
        System.out.println("Shooter Subsystem Shooting");
    }
    public void end(){
        neoShooter.set(0);
    }
}
