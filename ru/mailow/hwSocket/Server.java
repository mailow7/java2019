package ru.mailow.hwSocket;

import ru.mailow.hwTrading.Order;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                processThread(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void processThread(Socket clientSocket) {
        new Thread(() -> {
            try {
                process(clientSocket);
            } catch (IOException | ClassNotFoundException e) {

                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private static void process(Socket clientSocket) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        byte[] buf = new byte[10];

        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        ObjectInputStream is = new ObjectInputStream(in);
        Order order2 = (Order) is.readObject();
        System.out.println(order2.getName());

        clientSocket.close();
    }
}
