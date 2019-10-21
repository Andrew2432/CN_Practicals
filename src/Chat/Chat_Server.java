package Chat;

import java.io.*;
import java.net.*;
public class Chat_Server
{
    static ServerSocket serverSocket = null;
    static Socket socket = null;
    static BufferedReader br = null;
    static PrintWriter pw = null;
    static BufferedReader receiveRead = null;

    public static void main(String[] args) throws Exception
    {
        serverSocket = new ServerSocket(5000);
        System.out.println("Server  ready for chatting");
        socket = serverSocket.accept( );
        // reading from keyboard (keyRead object)
        br = new BufferedReader(new InputStreamReader(System.in));
        // sending to client (pwrite object)
        pw= new PrintWriter(socket.getOutputStream(), true);

        // receiving from server ( receiveRead  object)
        receiveRead= new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String receiveMessage, sendMessage;
        while(true)
        {
            if((receiveMessage = receiveRead.readLine()) != null)
            {
                System.out.println(receiveMessage);
            }
            sendMessage = br.readLine();
            pw.println(sendMessage);
            pw.flush();
        }
    }
}
