package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSystem;

public class cameraShoot extends CommandBase{
    DriveSubsystem driveSubsystem;
    ShooterSystem shooterSystem;
    Camera camera;
    double targetAngle = 0;
    long timerStart;
    boolean started = false;
    long duration = 1500;
    double tol = 3;
    public cameraShoot(DriveSubsystem driveSubsystem, ShooterSystem shooterSystem, Camera camera){
        this.driveSubsystem = driveSubsystem;
        this.shooterSystem = shooterSystem;
        this.camera = camera;
    }
    @Override
    public void initialize(){
        targetAngle = camera.getTargetYaw();
    }
    public void execute(){
        if(driveSubsystem.getHeading() < targetAngle - tol){
            // driveSubsystem.arcadeDrive(0, 0.45);
            System.out.println("turning pos");
        }
        else if(driveSubsystem.getHeading() > targetAngle + tol){
            // driveSubsystem.arcadeDrive(0, -0.45);
            System.out.println("turning Neg");
        }
        else if (driveSubsystem.getHeading() > targetAngle - tol && driveSubsystem.getHeading() < targetAngle + tol){
            // driveSubsystem.arcadeDrive(0, 0);
            // shooterSystem.shoot(1);
            System.out.println("shooting");
            if(!started){
                timerStart = System.currentTimeMillis();
                started = true;
            }
        }
    }
    public boolean isFinished(){
        return (duration < System.currentTimeMillis() - timerStart);
    }
    public void end(boolean interupted){
        shooterSystem.end();
        driveSubsystem.arcadeDrive(0, 0);
    }

}
