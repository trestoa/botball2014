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
		top.run(100);
		bottom.run(0);
		while(!this.topSensor.getValue());
		top.run(30);
		bottom.run(10);
		Botball.msleep(1000);
		bottom.off();
		top.off();
	}
	
	public void down() {
		top.run(0);
		bottom.run(100);
		while(!this.bottomSensor.getValue());
		bottom.run(30);
		top.run(10);
		Botball.msleep(1000);
		bottom.off();
		top.off();
	}
	
	public void shortup(int time) {
		if(topSensor.getValue())
			return;
		top.run(100);
		bottom.run(0);
		Botball.msleep(time);
		top.off();
		bottom.run(10);
		Botball.msleep(1000);
		bottom.off();
	}
	
	public void shortdown(int time) {
		if(bottomSensor.getValue())
			return;
		top.run(0);
		bottom.run(100);
		Botball.msleep(time);
		bottom.off();
		top.run(10);
		Botball.msleep(1000);
		top.off();
	}
	
	public void stopAll(){
		top.off();
		bottom.off();
	}
}
