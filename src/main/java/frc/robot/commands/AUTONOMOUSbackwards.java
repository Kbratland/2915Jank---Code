package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AUTONOMOUSbackwards extends CommandBase {
    public DriveSubsystem driveSubsystem;
    private long timerStart = 0;
    private long duration = 3000;

    public AUTONOMOUSbackwards(DriveSubsystem driveSubsystem, long duration) {
        addRequirements(driveSubsystem);
        this.driveSubsystem = driveSubsystem;
    }

    @Override
    public void initialize() {
        timerStart = System.currentTimeMillis();
    }

    public void execute() {
        driveSubsystem.arcadeDrive(-0.75, 0);
    }

    public boolean isFinished() {
        return System.currentTimeMillis() - timerStart >= duration;
    }

    public void end(boolean interrupted) {
        driveSubsystem.arcadeDrive(0, 0);
    }

}
