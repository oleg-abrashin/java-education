package test;

import java.io.IOException;
import response.MirrorServerResponse;
import response.Protocol;
import server.SingleThreadServer;

public class TCP_Server_Multi_Lines {

	static final int PORT = 2200;
	static final Protocol ONE_THREAD_PROTOCOL = new MirrorServerResponse();
	

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Dont forget to launch the client side");
		(new SingleThreadServer(PORT, ONE_THREAD_PROTOCOL)).go();
	}

}
