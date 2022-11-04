package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class BeltSystem extends SubsystemBase {
    private final WPI_TalonFX beltMover = new WPI_TalonFX(DriveConstants.kConveyorPort);
    public BeltSystem() {
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