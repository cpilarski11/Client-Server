import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String [] args) {

        BufferedReader fromServer;
        PrintWriter toServer;
        Socket sock;
        Scanner kbd = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Waiting to connect ...");

                sock = new Socket("10.32.95.69", 12345);

                System.out.println("Connected to" + sock.getInetAddress());

                fromServer =
                        new BufferedReader(
                                new InputStreamReader(sock.getInputStream()));
                toServer = new PrintWriter(sock.getOutputStream(), true);

                while (true) {
                    // server says something first
                    System.out.println("Waiting...");
                    String response = fromServer.readLine();
                    System.out.println("them:" + response);

                    System.out.print("me> ");
                    System.out.flush();
                    String s = kbd.nextLine();

                    toServer.println(s);
                }
            } catch (IOException e) {
                System.out.println("Server not online. Will try again in five seconds.");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                //e.printStackTrace();
                //return;
            }
        } // while
    }
}