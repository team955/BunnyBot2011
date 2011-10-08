/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.*;

/**
 *
 * @author RaiderPC
 */
public class Tilter {
	boolean pos;//true is to move forward
	Solenoid tilterOn;
	Solenoid tilterOff;

	public Tilter() {
		pos = false;
		tilterOn = new Solenoid(Vars.PneumaticSlot, Vars.TilterOnChannel);
		tilterOff = new Solenoid(Vars.PneumaticSlot, Vars.TilterOffChannel);
	}

	public void run(Joystick js) {
		boolean dump = js.getRawButton(Vars.DumpButton);
		if(js.getY()>Vars.TiltThreshold) {
			pos = true;
		}
		else if (js.getY() < -Vars.TiltThreshold)
			pos = false;

		if(dump)
			pos = !pos;

		tilterOn.set(pos);
		tilterOff.set(!pos);
	}
}
