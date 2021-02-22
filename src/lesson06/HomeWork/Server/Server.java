package lesson06.HomeWork.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {


        ServerSocket server = null;

        Socket socket = null;

        try {

            server = new ServerSocket(3522);
            System.out.println("Server is ready to work...");
            socket = server.accept();
            System.out.println("Added new client");

            Scanner in =  new Scanner(socket.getInputStream());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Server, write you message");
                        String msg = sc.nextLine();
                        System.out.println("The message was send");
                        out.println(msg);
                    }
                }
            }).start();

            while (true) {
                String msg = in.nextLine();
                if (msg.equals("/end")) break;
                System.out.println("Client: " + msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
