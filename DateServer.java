import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServer {
    // Change this to whatever port your instructor asks for (>1024)
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            // create a server socket listening on PORT
            ServerSocket sock = new ServerSocket(PORT);
            System.out.println("DateServer listening on port " + PORT);

            // now listen for connections
            while (true) {
                Socket client = sock.accept();  // wait for a client to connect
                System.out.println("Client connected: " + client.getInetAddress());

                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                // write the Date to the socket
                pout.println(new Date().toString());

                // close the socket and go back to listening for more connections
                client.close();
            }
        } catch (IOException ioe) {
            System.err.println("Server error: " + ioe);
        }
    }
}