package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;
import no.hvl.dat110.system.sensor.SensorImpl;

/**
 * @author Regine
 */
public class Sensor extends RPCStub {
	private SensorImpl sensorImpl;
	private byte RPCID = 1;

	// TODO
	// implement marshalling, call and unmarshalling for read RPC method
	public int read() {
		int temp = sensorImpl.read();
		System.out.println(temp);
		byte[] request = RPCUtils.marshallInteger(RPCID, temp);
		byte[] response = rpcclient.call(request);
		temp = RPCUtils.unmarshallInteger(response);
		return temp;
	}

}
