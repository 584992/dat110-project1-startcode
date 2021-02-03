package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	// connect to messaging server
	public Connection connect() {

		// TODO
		// create TCP socket for client and connection
		// create connection object
		
		Connection connection = null;

		try {
			// Lager en socket som skal pr�ve � koble seg til serveren v�r. :)
			Socket clientSocket = new Socket(server, port);
			connection = new Connection(clientSocket);
			
		} catch (IOException e) {
			System.out.println("TCPServer: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		return connection;
	}
}
