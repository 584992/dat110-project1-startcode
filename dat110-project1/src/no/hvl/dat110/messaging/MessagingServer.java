package no.hvl.dat110.messaging;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingServer {

	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * Accepts an incoming connection from a client
	 * @author Emma
	 * 
	 * @return messaging connection
	 */
	public Connection accept() {

		// accept TCP connection on welcome socket and create messaging connection
		// Vi har allerede en Serversocket (welcomeSocket) som er blitt initalisert i konstruktøren. 
		// Ved å bruke metoden welcomeSocket.accept() så 
		// får vi returnert en socket som vi kan bruke til å snakke med klienten. 
		
		
		
		Connection connection = null;

		try {
			connection = new Connection(welcomeSocket.accept());
		} catch (IOException e) {
			System.out.println("TCPServer: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
