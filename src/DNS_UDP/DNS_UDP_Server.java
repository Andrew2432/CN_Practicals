import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DNS_UDP_Server {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(1309);
            while (true) {
                byte[] sendByte = new byte[1024];
                byte[] receiveByte = new byte[1024];

                DatagramPacket receiver = new DatagramPacket(receiveByte, receiveByte.length);
                server.receive(receiver);

                String s = new String(receiver.getData()).trim();
                InetAddress ip_addr = receiver.getAddress();
                int port = receiver.getPort();

                String[] ip = {"165.165.80.80", "165.165.79.1"};
                String[] name = {"www.yoyo.com", "www.hello.com"};

                for (int i = 0; i < ip.length; i++) {
                    if (s.equals(ip[i])) {
                        sendByte = name[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendByte, sendByte.length, ip_addr, port);
                        server.send(sender);
                        break;
                    } else if (s.equals(name[i])) {
                        sendByte = ip[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendByte, sendByte.length, ip_addr, port);
                        server.send(sender);
                        break;
                    }
                }
            }
        } catch (IOException ie) {
            System.err.println("IO Error");
        }
    }
}
