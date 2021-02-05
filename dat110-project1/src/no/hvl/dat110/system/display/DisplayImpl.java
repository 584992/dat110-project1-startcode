package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

/**
 * @author Regine
 */
public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}

	public byte[] invoke(byte[] request) {

		// TODO:
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done int he SensorImpl for the read method
		// gj�r om meldingen klar til � skrive
		String str = RPCUtils.unmarshallString(request);
		// sysou meldingen
		write(str);
		byte rpcid = request[0];
		byte[] reply = RPCUtils.marshallVoid(rpcid);
		return reply;
	}
}
