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
    }

    @Override
    public void initialize() {
        timerStart = System.currentTimeMillis();
        System.out.println(timerStart);
    }

    public void execute() {
        shooterSystem.shoot();
        System.out.println("command spinning");
    }

    public boolean isFinished() {
        return System.currentTimeMillis() - timerStart >= duration;
    }

}
