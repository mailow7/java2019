package ru.mailow.hwSocket;

import ru.mailow.hwTrading.Order;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("172.17.3.65", 8000);
        //PrintWriter writer = new PrintWriter(socket.getOutputStream());
        PrintStream stream = new PrintStream(socket.getOutputStream());

        Order order = new Order("oil",25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new ObjectOutputStream(out).writeObject(order);
        byte[] bytes = out.toByteArray();

        System.out.println(order.getName());

       //ByteArrayOutputStream in = new ByteArrayOutputStream();
        //new ObjectInputStream(in).readObject(order2);



        stream.write(bytes);
        stream.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());

        socket.close();

    }
}
