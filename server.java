import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {

    public static void main(String [] args) {
        ServerSocket sock;
        Socket client;

        // two line buffered text streams
        BufferedReader fromClient;
        PrintWriter toClient;

        Scanner kbd = new Scanner(System.in);

        try {
            sock = new ServerSocket(12345);
            System.out.println("Waiting for connection");
            client = sock.accept();
            System.out.println("Connected to " + client.getInetAddress());
            fromClient =
                    new BufferedReader(
                            new InputStreamReader(client.getInputStream()));

            toClient = new PrintWriter(client.getOutputStream(), true);

            while (true) {
                System.out.print("me: ");
                System.out.flush();
                String s = kbd.nextLine();
                toClient.println(s); // put it on socket and continue

                System.out.println("Waiting ...");
                String response = fromClient.readLine();
                System.out.println("them: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}