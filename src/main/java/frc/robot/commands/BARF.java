package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.BeltSystem;

public class BARF extends CommandBase{
    public BeltSystem shooter;
    public IntakeSubsytem intake;
    private long timerStart = 0;
    private long duration = 2500;
    public BARF(BeltSystem shooter, IntakeSubsytem intake, long duration){
        addRequirements(shooter, intake);
        this.shooter = shooter;
        this.duration = duration;
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
        long e = System.currentTimeMillis() - timerStart;
        return (e >= duration);
    }
    public void end(boolean interrupted){
        shooter.stopConvey();
        intake.inend();
    }

}
