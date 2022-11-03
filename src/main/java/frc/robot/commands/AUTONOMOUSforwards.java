package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AUTONOMOUSforwards extends CommandBase {
    public DriveSubsystem driveSubsystem;
    private long timerStart = 0;
    private long duration = 3000;

    public AUTONOMOUSforwards(DriveSubsystem driveSubsystem, long duration) {
        addRequirements(driveSubsystem);
        this.driveSubsystem = driveSubsystem;
    }

    @Override
    public void initialize() {
        timerStart = System.currentTimeMillis();
    }

    public void execute() {
        driveSubsystem.arcadeDrive(-0.5, 0);
    }

    public boolean isFinished() {
        return System.currentTimeMillis() - timerStart >= duration;
    }

    public void end(boolean interrupted) {
        driveSubsystem.arcadeDrive(0, 0);
    }

}
