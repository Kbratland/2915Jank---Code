package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class IntakeSubsytem extends SubsystemBase {
    private final WPI_TalonSRX ballIntake = new WPI_TalonSRX (DriveConstants.kIntakePort);
    // Encoder encoder = new Encoder(0, 1);

    // public void resetEncoders() {
    // encoder.reset();
    // }

    public void AbsorbBalls(double speed) {
        ballIntake.set(speed);
    }
    public void EjectBalls(){
        ballIntake.set(1);
        System.out.println("Ejecting");
    }
    public void inend(){
        ballIntake.set(0);
    }
}
