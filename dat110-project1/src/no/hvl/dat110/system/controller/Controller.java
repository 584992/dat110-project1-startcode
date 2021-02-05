package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCServerStopStub;
import no.hvl.dat110.system.display.DisplayDevice;
import no.hvl.dat110.system.sensor.SensorDevice;

public class Controller  {
	
	private static int N = 5;
	
	/**
	 * @author Regine
	 * @param args
	 */
	public static void main (String[] args) {
		
		Display display = new Display();
		Sensor sensor = new Sensor();
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();
		
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);

		// connect to sensor and display RPC servers, GJORT
		displayclient.connect();
		sensorclient.connect();
		// create local display and sensor objects, GJORT
		DisplayDevice displaydevice;
		SensorDevice sensordevice;
		// register display and sensor objects in the RPC layer, ????
		displayclient.register(display);
		sensorclient.register(sensor);
		
		// register stop methods in the RPC layer
		displayclient.register(stopdisplay);
		sensorclient.register(stopsensor);
		
		// loop while reading from sensor and write to display via RPC
		for(int i = 0;i<N;i++) {
			int temp = sensor.read();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(temp);
			display.write(Integer.toString(temp));
		}
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
