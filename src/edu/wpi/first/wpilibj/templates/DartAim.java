/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.*;
import java.util.Calendar;

/**
 *
 * @author RaiderPC
 */
public class DartAim {
	Encoder encoder;
	Victor victor;
	PIDController controller;
	Gyro gyro;
	Victor trigger;//TODO

	public DartAim() {
		gyro = new Gyro(Vars.GyroSlot, Vars.GyroChannel);
		encoder = new Encoder(Vars.MotorSlot, Vars.DartAChannel, Vars.MotorSlot, Vars.DartBChannel);
		victor = new Victor(Vars.MotorSlot, Vars.DartMotorChannel);
		controller = new PIDController(Vars.DartP, Vars.DartI, Vars.DartP);

	}

	public void run(Joystick js) {
		double desiredAngle = js.getDirectionRadians();
		double currentAngle = encoder.getRaw();

		currentAngle += gyro.getAngle();
		currentAngle = (currentAngle < 0) ? 256. - ((-1 * currentAngle) % 256.) : currentAngle % 256.;
		currentAngle = currentAngle / 256. * 2 * Math.PI;
		desiredAngle = Math.abs(currentAngle - desiredAngle) > Math.PI ?
			(currentAngle - desiredAngle > 0 ? desiredAngle + (2 * Math.PI) : desiredAngle - (2 * Math.PI)) :
			desiredAngle;

		double speed = controller.out(desiredAngle, currentAngle, victor.getSpeed());

		victor.set(speed);

	}

	public void shoot(){

	}
}