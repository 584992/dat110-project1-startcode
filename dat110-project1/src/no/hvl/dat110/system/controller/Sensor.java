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
		int temp = SensorImpl.read();
		
		byte[] request = RPCUtils.marshallInteger(RPCID, message);
		byte[] response = rpcclient.call(request);
		RPCUtils.unmarshallInteger(response);
		return temp;
	}

}
