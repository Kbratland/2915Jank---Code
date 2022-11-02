package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsytem;

public class ABSORB extends CommandBase{
    public IntakeSubsytem intake;
    public ABSORB(IntakeSubsytem intake){
        addRequirements(intake);
        this.intake = intake;
    }
    @Override
    public void initialize(){

    }
    public void execute(){
        intake.AbsorbBalls();
    }
}
