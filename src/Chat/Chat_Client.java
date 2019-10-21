package Chat;

import java.io.*;
import java.net.*;
public class Chat_Client {
    static BufferedReader br = null;
    static Socket socket = null;
    static PrintWriter pw = null;
    static BufferedReader receiveRead = null;
    public static void main(String[] args) throws Exception
    {
        socket = new Socket("127.0.0.1", 5000);
        // reading from keyboard (keyRead object)
        br = new BufferedReader(new InputStreamReader(System.in));
        // sending to client (pwrite object)
        //OutputStream ostream = socket.getOutputStream();
        //PrintWriter pwrite = new PrintWriter(ostream, true);
        pw = new PrintWriter(socket.getOutputStream(), true);

        // receiving from server ( receiveRead  object)
        //InputStream istream = socket.getInputStream();
        //BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
        receiveRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Start the chitchat, type and press Enter key");

        String receiveMessage, sendMessage;
        while(true)
        {
            sendMessage = br.readLine();  // keyboard reading
            pw.println(sendMessage);       // sending to server
            pw.flush();                    // flush the data
            if((receiveMessage = receiveRead.readLine()) != null) //receive from server
            {
                System.out.println(receiveMessage); // displaying at DOS prompt
            }
        }
    }
}
