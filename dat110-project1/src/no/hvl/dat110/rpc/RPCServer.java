package no.hvl.dat110.rpc;

import java.util.HashMap;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.Connection;
import no.hvl.dat110.messaging.Message;
import no.hvl.dat110.messaging.MessagingServer;

public class RPCServer {

	private MessagingServer msgserver;
	private Connection connection;

	// hashmap to register RPC methods which are required to implement RPCImpl

	private HashMap<Integer, RPCImpl> services;

	public RPCServer(int port) {

		this.msgserver = new MessagingServer(port);
		this.services = new HashMap<Integer, RPCImpl>();

		// the stop RPC methods is built into the server
		services.put((int) RPCCommon.RPIDSTOP, new RPCServerStopImpl());
	}

	/**
	 * @author vilde
	 */
	public void run() {

		System.out.println("RPC SERVER RUN - Services: " + services.size());

		connection = msgserver.accept();

		System.out.println("RPC SERVER ACCEPTED");

		boolean stop = false;

		while (!stop) {

			int rpcid;

			// TODO
			// - (1) receive message containing RPC request
			// - (2) find the identifier for the RPC methods to invoke
			// - (3) lookup the method to be invoked
			// - (4) invoke the method
			// - (5) send back message containing RPC reply

			// 1.) Henter beskjeden
			Message RPCRequest = connection.receive();

			// 2.) Identifier = sensorid? byte32-47 = sensorId
			byte[] sensorId = new byte[15];
			
			for (int i = 0; i < RPCRequest.getData().length; i++) {
				sensorId[i] = RPCRequest.getData()[i];
			}

			// 3.)
			
			
			// 4.)
			

			// 5.)
			

			
			
			if (true) {
				throw new UnsupportedOperationException(TODO.method());
			}

			if (rpcid == RPCCommon.RPIDSTOP) {
				stop = true;
			}
		}

	}

	public void register(int rpcid, RPCImpl impl) {
		services.put(rpcid, impl);
	}

	public void stop() {
		connection.close();
		msgserver.stop();

	}
}
