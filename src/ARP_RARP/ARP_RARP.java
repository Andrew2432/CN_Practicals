import java.io.*;
import java.util.*;

public class ARP_RARP {
    private static final String arp_command = "arp -a";

    public static void getARPTable(String cmd) throws Exception {
        File fp = new File("ARP_Table.txt");
        FileWriter fw = new FileWriter(fp);
        BufferedWriter bw = new BufferedWriter(fw);
        Process p = Runtime.getRuntime().exec(cmd);
        Scanner s = new Scanner(p.getInputStream()).useDelimiter("\\A");

        while (s.hasNext()) bw.write(s.next());

        bw.close();
        fw.close();
    }

    public static void findMAC(String ip) throws Exception {
        File fp = new File("ARP_Table.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains(ip)) {
                System.out.println("Internet Address     Physical Address  Type");
                System.out.println(line);
                break;
            }
        }
        if (line == null) System.out.println("Not Found");
        fr.close();
        br.close();
    }


    public static void findIP(String mac) throws Exception {
        File fp = new File("ARP_Table.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains(mac)) {
                System.out.println("Internet Address     Physical Address  Type");
                System.out.println(line);
                break;
            }
        }
        if (line == null) System.out.println("Not Found");
        fr.close();
        br.close();
    }

    public static void main(String args[]) {

        try {
            getARPTable(arp_command);
            Scanner s = new Scanner(System.in);
            System.out.println("RARP Protocol");
            System.out.println("Enter MAC Address:");
            String mac = s.nextLine();
            findIP(mac);
        } catch(IOException e) {
            System.err.println("IO Error");
        }
        catch(Exception ex) {
            System.err.println("Error");
        }
    }
}