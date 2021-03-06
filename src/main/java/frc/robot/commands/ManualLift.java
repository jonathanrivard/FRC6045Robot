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

public class ManualLift extends Command { //Command to manually control the lift using the POV on the control stick
  public ManualLift() {
    requires(Robot.m_lift); //Require the lift system
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double input = Robot.m_oi.rightJoystick.getY();
    
    /*
    if(Robot.m_lift.getTopLimit() && input > 0){ //If the top limit is pressed and we are tring to go up
      Robot.m_lift.setPercentage(0); //Then don't
    }else if(Robot.m_lift.getBottomLimit() && input < 0){//If the bottom limit is pressed and we are tring to go down
      Robot.m_lift.setPercentage(0); //Then don't
    }else { //If neither of those
      Robot.m_lift.setPercentage(direction * RobotMap.SCALER_LIFT_MANUAL * Robot.m_oi.getControlThrottleScaler()); //Set the lift speed
    } */

    //Limit switches
    /*
    if(Robot.m_lift.getBottomLimit() && input < 0){
      input = 0;
      Robot.m_lift.setCurrentPosition(0);
    }else if(Robot.m_lift.getBottomLimit()){
      Robot.m_lift.setCurrentPosition(0);
    } */
    
    System.out.println(Robot.m_lift.getLiftMotor().getSelectedSensorPosition());
    Robot.m_lift.setPercentage(input * RobotMap.SCALER_LIFT_MANUAL * Robot.m_oi.getRightThrottleScaler());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_lift.setPercentage(0); //Set lift to 0
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}