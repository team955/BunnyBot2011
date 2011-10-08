/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author RaiderPC
 */
public class Vars {
	//Common Vars
	static int MotorSlot = 1;
	static int PneumaticSlot = 3;
	static double TiltThreshold = .02; //The dead zone of the joystick, between 0 and 1

	//Drive Vars
	static int LeftMotorPort = 1;
	static int RightMotorPort = 2;

	//Tilter Varws
	static int DumpButton = 2; //The button used to dump the bunnies
	static int TilterOnChannel = 1;
	static int TilterOffChannel = 2;

	//PID Controller Vars
	static double LoopTime = .01;

	//Dart Aimer Vars
	static int GyroSlot;
	static int GyroChannel;
	static int DartAChannel = 1;
	static int DartBChannel = 2;
	static int DartP = 100;
	static int DartI = 5;
	static int DartD = 5;
	static int DartMotorChannel = 3;
}