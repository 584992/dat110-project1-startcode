package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;

/**
 * 
 * @author Regine
 *
 */
public class DisplayDevice {

	public static void main(String[] args) {
		// TODO
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice
		System.out.println("Display server starting ...");
		DisplayImpl display = new DisplayImpl();
		RPCServer displayserver = new RPCServer(Common.DISPLAYPORT);
		displayserver.register(1, display);
		displayserver.run();
		displayserver.stop();

		System.out.println("Display server stopping ...");

	}
}
