import java.io.*;
import java.net.*;

public class DateClient {
    private static final String SERVER_HOST = "127.0.0.1"; 
    private static final int SERVER_PORT = 5000;           
    public static void main(String[] args) {
        try {
            Socket sock = new Socket(SERVER_HOST, SERVER_PORT);

            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = bin.readLine()) != null) {
                System.out.println("Server date/time: " + line);
            }

            sock.close();
        } catch (IOException ioe) {
            System.err.println("Client error: " + ioe);
        }
    }
}