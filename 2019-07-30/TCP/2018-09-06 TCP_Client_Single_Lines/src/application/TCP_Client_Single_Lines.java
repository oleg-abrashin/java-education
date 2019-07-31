package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCP_Client_Single_Lines {

	public static void main(String[] args) throws Exception {

		Socket client = new Socket(Config.HOST,Config.PORT);

		try(
//			Socket client = new Socket(Config.HOST, Config.PORT);
			BufferedReader readerTCP = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedReader readerKeyboard = new BufferedReader(new InputStreamReader(System.in));
			PrintStream writerTCP = new PrintStream(client.getOutputStream())
		){
			String line =null;
			while(true) {
				System.out.println("Enter any text or '" +Config.EXIT+"' to exit");
				line = readerKeyboard.readLine();
				if (line.equalsIgnoreCase(Config.EXIT)) break;
				writerTCP.println(line);
				System.out.println(readerTCP.readLine());	
			}
			client.close();	
		}	
	}

}
