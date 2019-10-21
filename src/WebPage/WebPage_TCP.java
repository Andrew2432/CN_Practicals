import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class WebPage_TCP {
    public static void main(String[] args) {

        String hostName = "www.google.com";
        int portNumber = 80;    //HTTP port number
        BufferedWriter bw = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            Socket socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            bw = new BufferedWriter( new FileWriter("Download.html"));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("GET / HTTP/1.1\nHost: "+ hostName +"\n\n");    //HTTP Request
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                bw.write(inputLine);
            }

            in.close();
            bw.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}