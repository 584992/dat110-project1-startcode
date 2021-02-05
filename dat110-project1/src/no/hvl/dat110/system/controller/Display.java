package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;
import no.hvl.dat110.system.display.DisplayImpl;

public class Display extends RPCStub {

	private byte RPCID = 1;

	/**
	 * @author Regine
	 * @param message
	 */
	public void write(String message) {
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] request = RPCUtils.marshallString(RPCID,message);
		DisplayImpl display = new DisplayImpl();
		byte[] response = display.invoke(request);
		RPCUtils.unmarshallString(response);
	}
}
