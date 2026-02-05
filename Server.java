import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(PORT);
            System.out.println("DateServer listening on port " + PORT);

            while (true) {
                Socket client = sock.accept();  
                System.out.println("Client connected: " + client.getInetAddress());

                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                pout.println(new Date().toString());

                client.close();
            }
        } catch (IOException ioe) {
            System.err.println("Server error: " + ioe);
        }
    }
}
