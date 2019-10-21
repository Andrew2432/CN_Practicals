package Echo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Echo_Client_Demo {
    static BufferedReader br = null;
    static BufferedWriter bw = null;
    static Socket socket = null;
    //static DataOutputStream dout = null;

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 5000);
            System.out.println("Connected");
            br = new BufferedReader(new InputStreamReader(System.in));
            //dout = new DataOutputStream(socket.getOutputStream());
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line = "";
            String result = "";

            while (!((line = br.readLine()).equals("Over"))) {
                result = result.concat(line) + "\n";
            }
            bw.write(result);
            br.close();
            bw.close();
            socket.close();
        } catch (UnknownHostException uhe) {
            System.err.println("Host Not Found");
        } catch (IOException ie) {
            System.err.println("IO Error");
        } catch (NullPointerException npe) {
            System.err.println("Null Pointer error");
        }
    }
}
