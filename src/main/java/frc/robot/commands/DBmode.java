
// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Camera;
// import frc.robot.subsystems.DriveSubsystem;

// public class DBmode extends CommandBase {
//     Camera camera;
//     double a = camera.getTargetArea();
//         double x = camera.getTargetYaw();
//         double tolx = 10;
//         double tolap = 10;
//         double tolan = 10;
//         boolean BatteringRam = false;
//         double r = 0;
//     DriveSubsystem driveSubsystem;
//     public DBmode(Camera camera, DriveSubsystem driveSubsystem) {
//      this.camera = camera; 
//      this.driveSubsystem = driveSubsystem;
//     }
//     public void initialize(){
//       tolx = 10;
//     }
//     public void execute(){
//     System.out.println("depth " + a + ", Yaw " + x);
//     if (x < -tolx && tolx < x){
//         if(x < -tolx){
//           r = -(x/10);
//           driveSubsystem.arcadeDrive(0, r);
//           }
//         if(x > tolx){
//           r =  (x/10); 
//           driveSubsystem.arcadeDrive(0, r);
//           }
//     }
//     if (BatteringRam && (a > tolap && a < tolan)){
//         if(a < tolan){ 
//           a = ((a * -1) + 5)/5;
//           driveSubsystem.arcadeDrive(a , 0);
//         }
//           if (a < tolap){
//           a = 0.45;
//           driveSubsystem.arcadeDrive(a , 0);
//           }
//         }
//           driveSubsystem.arcadeDrive(0, 0);
//         }

// public void end (boolean interupted){
//   driveSubsystem.arcadeDrive(0, 0);
//     }

// public boolean isFinished(){
//     return false;
//   }

// }
