package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.ShooterSystem;

public class BARF extends CommandBase{
    public ShooterSystem shooter;
    public IntakeSubsytem intake;
    private long timerStart = 0;
    private long duration = 5000;
    public BARF(ShooterSystem shooter, IntakeSubsytem intake){
        addRequirements(shooter, intake);
        this.shooter = shooter;
        this.intake = intake;
    }
    @Override
    public void initialize(){
        timerStart = System.currentTimeMillis();
    }
    public void execute(){
        shooter.barf();
        intake.EjectBalls();
    }
    public boolean isFinished(){
        return (System.currentTimeMillis() - timerStart >= duration);
    }

}
