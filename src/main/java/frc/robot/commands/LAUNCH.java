package frc.robot.commands;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class LAUNCH extends CommandBase {
    public ShooterSystem Shooter;
    double speed = 1;
    public LAUNCH(ShooterSystem shooter, double speed) {
        addRequirements(shooter);
        this.shooter = shooter;
        this.speed = speed;
        System.out.println();
    }

    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        system.out.println("attempting to shoot");
        shooterSystem.shoot(speed);
    }
    public boolean isFinished() {
        return false;
    }
    public void end(boolean interrupted){
        shooterSystem.end();
    }
}
