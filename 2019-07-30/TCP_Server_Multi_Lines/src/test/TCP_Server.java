package test;

import java.io.IOException;
import response.MirrorServerResponse;
import response.Protocol;
import server.MultiThreadServer;

public class TCP_Server {

	static final int PORT = 2100;
	static final Protocol ONE_THREAD_PROTOCOL = new MirrorServerResponse();
	

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Dont forget to launch the client side");

		MultiThreadServer multiThreadServer = new MultiThreadServer(PORT, ONE_THREAD_PROTOCOL);
		multiThreadServer.go();
	}

}
