package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BeltSystem;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSystem;

public class cameraShoot extends CommandBase{
    DriveSubsystem driveSubsystem;
    ShooterSystem shooterSystem;
    BeltSystem beltSystem;
    Camera camera;
    double targetAngle = 0;
    long timerStart = 10;
    boolean started = false;
    long duration = 1500;
    double tol = 3;
    public cameraShoot(DriveSubsystem driveSubsystem, ShooterSystem shooterSystem, Camera camera, BeltSystem beltSystem){
        this.driveSubsystem = driveSubsystem;
        this.shooterSystem = shooterSystem;
        this.beltSystem = beltSystem;
        this.camera = camera;
    }
    @Override
    public void initialize(){
        targetAngle = camera.getTargetYaw();
        driveSubsystem.zeroHeading();
        // targetAngle *= -1;
    }
    public void execute(){
       
        double currHeading = driveSubsystem.getHeading();
        if (!started){
            System.out.println("Target is " + targetAngle);
            System.out.println("Current angle is " + currHeading);
            if(currHeading < targetAngle - tol){
                //turn right
                driveSubsystem.arcadeDrive(0, 0.55);
                System.out.println("turning pos");
                shooterSystem.end();
            }
            else if(currHeading > targetAngle + tol){
                //turn left
                driveSubsystem.arcadeDrive(0, -0.55);
                System.out.println("turning Neg");
                shooterSystem.end();
            }
            else{
                //we're in the range
                driveSubsystem.arcadeDrive(0, 0);
                timerStart = System.currentTimeMillis();
                started = true;

            }            
        }
        else{
                //we have started shooting sequence
                shooterSystem.shoot(1);
                beltSystem.convey();
        }
    }
    public boolean isFinished(){
        return ( started && duration < System.currentTimeMillis() - timerStart);
    }
    public void end(boolean interupted){
        shooterSystem.end();
        beltSystem.stopConvey();
        driveSubsystem.arcadeDrive(0, 0);
    }

}