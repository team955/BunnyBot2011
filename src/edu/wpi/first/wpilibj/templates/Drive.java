/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.*;
import java.lang.Math.*;

/**
 *
 * @author RaiderPC
 */
public class Drive {
	Victor leftMotor, rightMotor;
	
	public Drive(){
		leftMotor = new Victor(Vars.MotorSlot, Vars.LeftMotorPort);
		rightMotor = new Victor(Vars.MotorSlot, Vars.RightMotorPort);
	}
	
	public void run(Joystick js){
		double x, y;
		x = js.getX();
		y = js.getY();
		if (x*x + y*y > Vars.TiltThreshold) {
			leftMotor.set(Math.max(Math.min(y - x, 1.0), -1.0));
			rightMotor.set(Math.max(Math.min(y + x, 1.0), -1.0));
		}
		else {
			leftMotor.set(0);
			rightMotor.set(0);
		}
	}
}
