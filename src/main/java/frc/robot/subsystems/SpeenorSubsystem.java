public class SpeenorSubsystem {
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import edu.wpi.first.wpilibj.Encoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class SpeenorSubsystem extends SubsystemBase {

    private final CANSparkMax FLD = new CANSparkMax(DriveConstants.kFrontLeftMotorPortDrive, MotorType.kBrushless);
    private final CANSparkMax FLS = new CANSparkMax(DriveConstants.kFrontLeftMotorPortSpeen, MotorType.kBrushless);

    private final CANSparkMax FRD = new CANSparkMax(DriveConstants.kFrontRightMotorPortDrive, MotorType.kBrushless);
    private final CANSparkMax FRS = new CANSparkMax(DriveConstants.kFrontRightMotorPortSpeen, MotorType.kBrushless);

    private final CANSparkMax BLD = new CANSparkMax(DriveConstants.kBackLeftMotorPortDrive, MotorType.kBrushless);
    private final CANSparkMax BLS = new CANSparkMax(DriveConstants.kVackLeftMotorPortSpeen, MotorType.kBrushless);

    private final CANSparkMax BRD = new CANSparkMax(DriveConstants.kBackRightMotorPortDrive, MotorType.kBrushless);
    private final CANSparkMax BRS = new CANSparkMax(DriveConstants.kBackRightMotorPortSpeen, MotorType.kBrushless);

    // private final WPI_TalonFX beltMover = new WPI_TalonFX(DriveConstants.kConveyorPort);
    public SpeenorSubsystem() {
    }

    public void FLspinto(double angle){
        //angle will be the angle according to the driversation heading as 0 
        
        if (angle > 180){
            angle = (angle - 180)*-1;
        }
        //pid command
    }

    public void FRspinto(double angle){
        if (angle > 180){
            angle = (angle - 180)*-1;
        }
        //pid command
    }

    public void BLspinto(double angle){
        if (angle > 180){
            angle = (angle - 180)*-1;
        }
        //pid command
    }

    public void BRspinto(double angle){
        if (angle > 180){
            angle = (angle - 180)*-1;
        }
        //pid command
    }

    public void shoot(double speed) {
        neoShooter.set(speed);
        System.out.println("Shooter Subsystem Shooting");
    }
    public void end(){
        neoShooter.set(0);
    }
   /*public void linearControll(double speed){
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
    }*/
}
}