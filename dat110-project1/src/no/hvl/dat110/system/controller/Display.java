package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	/**
	 * @author Regine
	 * @param message
	 */
	public void write(String message) {
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] request = RPCUtils.marshallString(RPCID,message);
		byte[] response = rpcclient.call(request);
		RPCUtils.unmarshallString(response);
	}
}
