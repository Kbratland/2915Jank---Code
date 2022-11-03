package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsytem;

public class ABSORB extends CommandBase{
    public IntakeSubsytem intake;
    public Joystick joystick = new Joystick(0);
    double speed = 0.75;
    public ABSORB(IntakeSubsytem intake,Joystick joystick){
        addRequirements(intake);
        this.intake = intake;
        this.joystick = joystick;
    }
    @Override
    public void initialize(){
        System.out.println(joystick.getRawAxis(3));
    }
    @Override
    public void execute(){
        System.out.println(joystick.getRawAxis(3));
        intake.AbsorbBalls(joystick.getRawAxis(3));
    }
    public boolean isFinished(){
        return false;
    }
    public void end(boolean interupted){
        intake.inend();
    }
}
