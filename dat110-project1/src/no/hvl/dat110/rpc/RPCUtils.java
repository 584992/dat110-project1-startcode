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
		encoded = new byte[mid.length];
		encoded[0] = rpcid;
		
		for(int i = 1; i < mid.length; i++) {
			encoded[i] = mid[i];	
		}
		
		return encoded;
	}

	
	/**
	 * @author Regine
	 * @param data in bytes
	 * @return data unmarshalled into String
	 */
	public static String unmarshallString(byte[] data) {
		// TODO: unmarshall String contained in data into decoded
		String decoded = new String(data);
		return decoded;
	}

	
	
	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = {rpcid};

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		//
	}

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

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	/**
	 * @author Regine
	 * @param rpcid
	 * @param x
	 * @return
	 */
	public static byte[] marshallInteger(byte rpcid, int x) {
		// TODO: marshall RPC identifier and string into byte array
		BigInteger bigInt = BigInteger.valueOf(x);      
		byte[] encoded = bigInt.toByteArray();
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {
		// TODO: unmarshall integer contained in data
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
		int decoded = byteBuffer.getInt();
		return decoded;

	}
}
