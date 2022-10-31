package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class LAUNCH extends CommandBase {
    public ShooterSystem shooterSystem;
    double speed = 0;
    private long timerStart = 0;
    private long duration = 5000;

    public LAUNCH(long duration) {
        this.duration = duration;
    }

    public void initialize() {
        timerStart = System.currentTimeMillis();
    }

    public void execute() {
        shooterSystem.shoot();
    }

    public boolean isFinished() {
        return System.currentTimeMillis() - timerStart >= duration;
    }

}
