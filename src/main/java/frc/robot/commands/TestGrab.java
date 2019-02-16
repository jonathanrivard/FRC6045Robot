/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TestGrab extends Command {
  public TestGrab() {
    requires(Robot.m_clawGrabber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double input = Robot.m_oi.controlJoystick.getY() * -1;
   
    /*
    if(Robot.m_clawGrabber.getOpenLimit() && input > 0){ //If the open limit is pressed and we are tring to go up
      Robot.m_clawGrabber.setPercentage(0); //Then don't
    }else if(Robot.m_clawGrabber.getClosedLimit() && input < 0){//If the closed limit is pressed and we are tring to go down
      Robot.m_clawGrabber.setPercentage(0); //Then don't
    }else { //If neither of those
      Robot.m_clawGrabber.setPercentage(input); //Set the lift speed
    } */

    input *= Robot.m_oi.getControlThrottleScaler();
    Robot.m_clawGrabber.setPercentage(input);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_clawGrabber.setPercentage(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
