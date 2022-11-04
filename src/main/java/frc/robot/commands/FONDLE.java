package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.BeltSystem;


public class FONDLE extends CommandBase{
    public BeltSystem convey;
    public Joystick joystick = new Joystick(0);;
    double speed = 0.75;
    public FONDLE(BeltSystem convey,Joystick joystick){
        addRequirements(convey);
        this.joystick = joystick;
        this.convey = convey;
    }
    @Override
    public void initialize(){
        System.out.println(joystick.getRawAxis(2));
    }
    @Override
    public void execute(){
        System.out.println(joystick.getRawAxis(2));
        convey.linearControll(joystick.getRawAxis(2)/4);
    }
    public boolean isFinished(){
        return false;
    }
    public void end(boolean interupted){
        convey.stopConvey();
    }
}
