package Lesson_3_Bonus;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Server();
    }

    public Server() throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(8189);
        Socket socket;
        System.out.println("Сервер запущен!");
        socket = server.accept();
        System.out.println("Клиент " + socket.toString() + " подключился");

        ObjectInputStream ois = new ObjectInputStream(new DataInputStream(socket.getInputStream()));
        Player s2 = (Player) ois.readObject();
        Book b2 = (Book) ois.readObject();
        ois.close();
        s2.info();
        b2.info();
    }
}
