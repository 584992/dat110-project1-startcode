package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;
import no.hvl.dat110.system.sensor.SensorImpl;

/**
 * @author Regine
 */
public class Sensor extends RPCStub {
	
	private byte RPCID = 1;

	// TODO
	// implement marshalling, call and unmarshalling for read RPC method
	public int read() {
		byte[] request = RPCUtils.marshallVoid(RPCID);
		SensorImpl sensor = new SensorImpl();
		byte[] reply = sensor.invoke(request);
		int temp = RPCUtils.unmarshallInteger(reply);
		System.out.println(temp);
		return temp;
	}

}
