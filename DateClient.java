import java.io.*;
import java.net.*;

public class DateClient {
    // Use the IP/hostname of the machine running the server
    private static final String SERVER_HOST = "127.0.0.1"; // "localhost"
    private static final int SERVER_PORT = 5000;           // must match DateServer.PORT

    public static void main(String[] args) {
        try {
            // make connection to server socket
            Socket sock = new Socket(SERVER_HOST, SERVER_PORT);

            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            // read the date from the socket
            String line;
            while ((line = bin.readLine()) != null) {
                System.out.println("Server date/time: " + line);
            }

            // close the socket connection
            sock.close();
        } catch (IOException ioe) {
            System.err.println("Client error: " + ioe);
        }
    }
}