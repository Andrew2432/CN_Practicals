import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class WebPage_URL {
    public static void DownloadWebPage(String webpage) {
        try {
            URL url = new URL(webpage);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter bw = new BufferedWriter( new FileWriter("Download.html"));
            String line;
            while ((line = br.readLine()) != null)  bw.write(line);

            br.close();
            bw.close();
            System.out.println("Successfully Downloaded");
        } catch(MalformedURLException e) {
            System.err.println("URL Error");
        }
        catch (IOException f) {
            System.err.println("IO Error");
        }
    }

    public static void main(String[] args) throws IOException{
        String url = "https://www.google.com";
        DownloadWebPage(url);
    }
}