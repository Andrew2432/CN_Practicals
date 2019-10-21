package Daytime;

import java.net.*;
import java.io.*;

/**
 * This program is a socket client application that connects to a time server
 * to get the current date time.
 *
 * @author www.codejava.net
 */
public class Daytime {

    static BufferedReader br = null;
    public static void main(String[] args) {
        String hostname = "time.nist.gov";
        int port = 13;

        try (Socket socket = new Socket(hostname, port)) {

            //InputStream input = socket.getInputStream();
            //InputStreamReader reader = new InputStreamReader(input);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int character;
            StringBuilder data = new StringBuilder();

            while ((character = br.read()) != -1) {
                data.append((char) character);
            }

            System.out.println(data);


        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}