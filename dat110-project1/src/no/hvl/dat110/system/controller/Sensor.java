package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

/**
 * 
 * @author Regine
 *
 */
public class Sensor extends RPCStub {

	private byte RPCID = 1;

	// TODO
	// implement marshalling, call and unmarshalling for read RPC method
	public int read() {
		int temp;
		byte[] request = RPCUtils.marshallString(RPCID, message);
		byte[] response = rpcclient.call(request);
		RPCUtils.unmarshallString(response);
		return temp;
	}

}
