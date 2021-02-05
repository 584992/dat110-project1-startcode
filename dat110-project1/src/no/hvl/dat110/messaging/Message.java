package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {
	

	private byte[] payload;

	public Message(byte[] payload) throws Exception {
		
		if(payloadLengthOK(payload)) {
			this.payload = payload;
		}else {
			System.out.println("payload lengden er over 128 bits.");
			throw new Exception();
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}
	
	/**
	 * @author vilde
	 * @return encoded -> den nye payloaden som blir encapsulated. hh
	 */
	public byte[] encapsulate() {
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		byte[] encoded = new byte[128]; // Bytes som vi ønsker å encapulate, i størrelse 128

		encoded[0] = ((Integer) payload.length).byteValue(); // Gjør om til byte value

		for (int i = 1; i <= payload.length; i++) { // stapper payload inn i encoded, byte for byte
			encoded[i] = payload[i - 1];
		}

		return encoded;

	}

	/**
	 * @author vilde & emma
	 * @param received -> payloaden blir omgjort (fjerner header, altså byte-lengden
	 *                 på plass[0])
	 */
	public void decapsulate(byte[] received) {
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message
	//	int lengde = received.length;
	//	System.out.println(lengde);
		payload = new byte[received[0]];

		for (int i = 0; i < payload.length; i++) {
			payload[i] = received[i+1];
		}

	}
	
	private boolean payloadLengthOK(byte [] p) {
		return (p.length <= 128);
	}
}
