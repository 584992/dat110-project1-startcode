package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	
	/**
	 * 
	 * @author Emma & Regine
	 * @param rpcid
	 * id-en til RPC
	 * 
	 * @param str
	 * Stringen som skal bli gjort om til en tabell av bytes.
	 * 
	 * 
	 * @return tabell av bytes + ekstra info. 
	 */
	public static byte[] marshallString(byte rpcid, String str) {
		
		// TODO: marshall RPC identifier and string into byte array
		
		byte[] encoded;
		byte[] mid = str.getBytes();
		encoded = new byte[mid.length +1];
		encoded[0] = rpcid;
		
		for(int i = 0; i < mid.length; i++) {
			encoded[i+1] = mid[i];	
		}
		
		return encoded;
	}

	
	/**
	 * @author Regine & Emma
	 * @param data in bytes
	 * @return data unmarshalled into String
	 */
	public static String unmarshallString(byte[] data) {
		// TODO: unmarshall String contained in data into decoded
		
		byte[] mid = new byte[data.length - 1];
		for(int i = 0; i < mid.length; i++) {
			mid[i] = data[i+1];
		}
		
		String decoded = new String(mid);
		return decoded;
	}

	
	/**
	 * @author ehell
	 * @param rpcid
	 * @return
	 */
	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = {rpcid};

		return encoded;

	}

	/**
	 * @author ehell
	 * @param data
	 */
	public static void unmarshallVoid(byte[] data) {

	// Gjør ingenting. Trenger ikke å bli kalt. 
	// Fra discord: 
	// "Ja - unmarshallVoid gjør ingenting siden der ikke er noe å "unmarshalle" - 
	// så det spiller ikke noen rolle om en kaller unmarshall eller ikke.
	}
	
	/**
	 * @author Regine
	 * @param rpcid
	 * @param b
	 * @return
	 */
	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	/**
	 * @author Regine
	 * @param data
	 * @return
	 */
	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	/**
	 * @author Regine & Emma
	 * @param rpcid
	 * @param x
	 * @return
	 */
	public static byte[] marshallInteger(byte rpcid, int x) {
		// TODO: marshall RPC identifier and string into byte array
		byte[] midlertidig = BigInteger.valueOf(x).toByteArray();
		byte[] encoded = new byte[midlertidig.length+1];
		
		encoded[0] = rpcid;
		for(int i = 0; i < midlertidig.length; i++) {
			encoded[i+1] = midlertidig[i];
		}
			
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {
		// TODO: unmarshall integer contained in data
		
		byte[] midlertidig = new byte[data.length -1];
		
		for(int i = 0; i < midlertidig.length; i++) {
			midlertidig[i] = data[i+1];
		}
		
		ByteBuffer byteBuffer = ByteBuffer.wrap(midlertidig);
		
		int decoded = byteBuffer.getInt();
		return decoded;

	}
}
