/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ManualTilt extends Command { //Manual Tilt Command using control joysick for claw
  public ManualTilt() {
    requires(Robot.m_clawTilter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double input = Robot.m_oi.controlJoystick.getZ(); //Get z axis
    
    /*
    if(input > 0 && Robot.m_clawTilter.getTopLimit()){ //If we are going up and we hit the up limit
      Robot.m_clawTilter.setPercentage(0); //Then don't
    }else if(input < 0 && Robot.m_clawTilter.getBottomLimit()){ //If we are going down and we hit the down limit
      Robot.m_clawTilter.setPercentage(0); //Then don't
    }else {
      Robot.m_clawTilter.setPercentage(input); //Other wise set the motor to the z axis
    } */

    Robot.m_clawTilter.setPercentage(input * RobotMap.SCALER_CLAW_TILT);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_clawTilter.setPercentage(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
