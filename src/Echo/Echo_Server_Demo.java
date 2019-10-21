package Echo;

import java.io.*;
import java.net.*;

public class Echo_Server_Demo {

    static Socket socket = null;
    static ServerSocket serverSocket = null;
    static BufferedReader br = null;

    public static void main(String[] args) {
        try{
            serverSocket = new ServerSocket(5000);
            System.out.println("Server Started");
            System.out.println("Waiting for a client ...");

            socket = serverSocket.accept();
            System.out.println("Client connected");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;

            while (!((line = br.readLine()).equals("Over"))) {
                System.out.println(line);
            }
            System.out.println("Closing connection");
            br.close();
            serverSocket.close();
            socket.close();
        } catch (IOException ie) {
            System.err.println("IO Error");
        } catch (NullPointerException npe) {
            //System.err.println("Null pointer error");
        }
    }
}
