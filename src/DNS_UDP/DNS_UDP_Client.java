import java.io.*;
import java.net.*;

public class DNS_UDP_Client {
    public static void main(String[] args) {
        try {
            // UDP connection
            DatagramSocket client = new DatagramSocket();

            // IP address
            InetAddress ip_addr = InetAddress.getByName("127.0.0.1");

            byte[] sendByte = new byte[1024];
            byte[] receiveByte = new byte[1024];

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the domain name or IP address:");
            String input = br.readLine();
            sendByte = input.getBytes();

            DatagramPacket sender = new DatagramPacket(sendByte, sendByte.length, ip_addr, 1309);
            client.send(sender);

            DatagramPacket receiver = new DatagramPacket(receiveByte, receiveByte.length);
            client.receive(receiver);

            String s = new String(receiver.getData());
            System.out.println("IP address or Domain name:" + s.trim());
            client.close();
        } catch (IOException ie) {
            System.err.println("IO Error");
        }
    }
}
