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
		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] request = RPCUtils.marshallVoid(RPCCommon.RPIDSTOP);

		byte[] response = rpcclient.call(request);

		RPCUtils.unmarshallVoid(response);

	}
}
