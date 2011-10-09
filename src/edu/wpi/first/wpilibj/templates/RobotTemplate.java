/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;


public class RobotTemplate extends IterativeRobot {

	Joystick mainJS;
	Joystick turretJS;
	Drive drive;
	Tilter tilter;
	DartAim darter;
    public void robotInit() {
		mainJS = new Joystick(Vars.mainJSPort);
		turretJS = new Joystick(Vars.turretJSPort);
		drive = new Drive();
		tilter = new Tilter();
		darter = new DartAim();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.run(mainJS);
		tilter.run(mainJS);
		darter.run(turretJS);
    }
}
