package no.hvl.dat110.rpc;

import java.net.Socket;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;


public class RPCClient extends RPCStub {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	/**
	 * @author ehell
	 */
	public void connect() {
		
		// TODO: connect using the underlying messaging layer connection
		
		connection = msgclient.connect();
		
		
	   // throw new UnsupportedOperationException(TODO.method());
			
	}
	/**
	 * @author ehell
	 */
	
	public void disconnect() {
		
		connection.close();
		
		// TODO: disconnect/close the underlying messaging connection
		
		//throw new UnsupportedOperationException(TODO.method());
		
	}
	/**
	 * @author ehell
	 * @param rpcrequest
	 * @return
	 */
	public byte[] call(byte[] rpcrequest) {
		
		// implements the client-side of the RPC layer using the client-side 
		// of the underlying messaging layer for communication.
		
		byte[] rpcreply;
		
		Message sendMessage = new Message(rpcrequest);
		
		connection.send(sendMessage);
		
		
		
		Message recieveMessage = connection.receive();
		
		rpcreply = recieveMessage.getData();
		/*
		
		Make a remote call on the RPC server by sending the RPC request message
		and receive an RPC reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		
		return rpcreply;
		
	}

}
