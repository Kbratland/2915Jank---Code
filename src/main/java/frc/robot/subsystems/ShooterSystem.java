package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import edu.wpi.first.wpilibj.Encoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class ShooterSystem extends SubsystemBase {
    private final CANSparkMax neoShooter = new CANSparkMax(DriveConstants.kShooterPort, MotorType.kBrushless);
    private final WPI_TalonFX beltMover = new WPI_TalonFX(DriveConstants.kConveyorPort);
    public ShooterSystem() {
    }
    public void shoot(double speed) {
        neoShooter.set(speed);
        System.out.println("Shooter Subsystem Shooting");
    }
    public void end(){
        neoShooter.set(0);
    }
    public void linearControll(double speed){
        beltMover.set(speed);
    }
    public void convey(){
        beltMover.set(-1);
    }
    public void stopConvey(){
        beltMover.set(0);
    }
    public void barf(){
        beltMover.set(1);
        System.out.println("Barfing");
    }
}
