package at.shufflebots.modules;

import linkjvm.Botball;
import linkjvm.motors.Motor;
import linkjvm.sensors.digital.DigitalSensor;

public class Elevator {

	private Motor top;
	private Motor bottom;
	private DigitalSensor topSensor;
	private DigitalSensor bottomSensor;
	
	public Elevator(int top_motor_port, int bottom_motor_port, int top_sensor_port, int bottom_sensor_port) {
		top = new Motor(top_motor_port);
		bottom = new Motor(bottom_motor_port);
		topSensor = new DigitalSensor(top_sensor_port);
		bottomSensor = new DigitalSensor(bottom_sensor_port);
	}
	
	public void up() {
		top.run(-100);
		bottom.run(7);
		while(!this.topSensor.getValue());
		top.off();
		bottom.off();
	}
	
	public void down() {
		top.run(7);
		bottom.run(-100);
		while(!this.bottomSensor.getValue());
		top.off();
		bottom.off();
	}
	
	public void shortup() {
		if(topSensor.getValue())
			return;
		top.run(-100);
		bottom.run(7);
		Botball.msleep(1200);
		top.off();
		bottom.off();
	}
	
	public void shortdown() {
		if(bottomSensor.getValue())
			return;
		top.run(7);
		bottom.run(-100);
		Botball.msleep(900);
		top.off();
		bottom.off();
	}
}
