package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import response.Protocol;

public class SocketThread implements Runnable {

    private Socket clientConnection;
    private Protocol protocol;

    public SocketThread(Socket clientConnection, Protocol protocol) {
        super();
        this.clientConnection = clientConnection;
        this.protocol = protocol;
    }

    public void run() {

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
                PrintStream writer = new PrintStream(clientConnection.getOutputStream())
        ) {
            String request;
            while (true) {
                request = reader.readLine();
                if (request == null) break;
                writer.println(protocol.getResponse(request));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
