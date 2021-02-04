package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	/**
	 * @author vilde
	 * @return encoded -> den nye payloaden som blir encapsulated. 
	 */
	public byte[] encapsulate() {
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		byte[] encoded = new byte[128]; //Bytes som vi ønsker å encapulate, i størrelse 128
		
		encoded[0] = ((Integer) this.payload.length).byteValue(); //Gjør om til byte value
		
		for (int i = 1; i <= this.payload.length; i++) { //stapper payload inn i encoded, byte for byte
			encoded[i] = this.payload[i-1];
		}
		
		
		return encoded;
		
	}

	/**
	 * @author vilde
	 * @param received -> payloaden blir omgjort (fjerner header, altså byte-lengden på plass[0])
	 */
	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		int lengde = received.length;
		payload = new byte[lengde];
		
		for (int i = 0; i < this.payload.length; i++) {
			this.payload[i] = received[i];
		}
		
		
//		throw new UnsupportedOperationException(TODO.method());
		
	}
}
