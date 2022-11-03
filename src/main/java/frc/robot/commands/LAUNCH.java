package frc.robot.commands;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class LAUNCH extends CommandBase {
    public ShooterSystem shooterSystem;
    double speed = 0;
    public LAUNCH(ShooterSystem shooter) {
        addRequirements(shooter);
        System.out.println();
    }

    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        shooterSystem.shoot();
    }
  
    public void end(boolean interrupted){
        shooterSystem.end();
    }
    @Override
    public boolean isFinished() {
        return false;
    }

}
