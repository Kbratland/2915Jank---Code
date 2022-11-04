package frc.robot.commands;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class LAUNCH extends CommandBase {
    double speed = 1;
    private ShooterSystem shooterSystem;
    public LAUNCH(ShooterSystem shooterSystem, double speed) {
        addRequirements(shooterSystem);
        this.shooterSystem = shooterSystem;
        this.speed = speed;
        System.out.println();
    }

    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        System.out.println("attempting to shoot");
        shooterSystem.shoot(speed);
    }
    public boolean isFinished() {
        return false;
    }
    public void end(boolean interrupted){
        shooterSystem.end();
    }
}
