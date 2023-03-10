package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;

public class DriveBackwardCommand extends CommandBase {
  private final SwerveSubsystem swerve; 
  private double desiredEnc; 

  public DriveBackwardCommand(SwerveSubsystem newSwerve, double newDesiredEnc) {
    swerve = newSwerve; 
    desiredEnc = newDesiredEnc; 

    addRequirements(swerve);
  }

  @Override
  public void initialize() {
    swerve.resetEnc();
  }

  @Override
  public void execute() {
    SmartDashboard.putString("Current Command", getName());
    swerve.driveBackward();
  }

  @Override
  public void end(boolean interrupted) {
    swerve.stopModules();
  }

  @Override
  public boolean isFinished() {
    return swerve.getEnc() < -desiredEnc;
  }
}
