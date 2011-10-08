package edu.wpi.first.wpilibj.templates;

public class PIDController {

	double kP, kI, kD;
	double P, I, D = 0;
	double lastValue = 0;
	double output = 0;
	boolean init = false;

	public PIDController(double kP, double kI, double kD) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
	}

	public double out(double targetValue, double currentValue, double currentSpeed) {
		P = targetValue - currentValue;
		I = I + P * Vars.LoopTime;
		D = -currentSpeed;
		if (I > 200) {
			I = 0;
		}
		output = (kP * P) + (kI * I) + (kD * D);
		return output;
	}

	public void pidReset() {
		P = 0;
		I = 0;
		D = 0;
	}
}
