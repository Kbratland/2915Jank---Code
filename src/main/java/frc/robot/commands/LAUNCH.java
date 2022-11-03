package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class LAUNCH extends CommandBase {
    public ShooterSystem shooterSystem;
    double speed = 0;
    private long timerStart = 0;
    private long duration = 5000;

    public LAUNCH(long duration, ShooterSystem shooter) {
        this.duration = duration;
        this.shooterSystem = shooter;
        addRequirements(shooter);
        System.out.println(duration);
    }

    @Override
    public void initialize() {
        timerStart = System.currentTimeMillis();
        System.out.println(timerStart);
    }
    @Override
    public void execute() {
        shooterSystem.shoot();
        if(System.currentTimeMillis() - timerStart >= duration - 750){
            shooterSystem.convey();
        }
    }
  
    public void end(boolean interrupted){
        shooterSystem.end();
        shooterSystem.stopConvey();
    }
    @Override
    public boolean isFinished() {
        long e = System.currentTimeMillis() - timerStart;
        return (e >= duration);
    }

}
