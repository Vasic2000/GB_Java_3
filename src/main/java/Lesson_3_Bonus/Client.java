package Lesson_3_Bonus;

import java.io.*;
import java.net.Socket;

public class Client {
    final static String IP_ADRESS = "localhost";
    final static int PORT = 8189;
    static Socket socket;
    static ObjectOutputStream oos;

    public static void main(String[] args) throws IOException {
        new Client();
    }

    public Client() throws IOException {
        Students s = new Students(100, "Artem");
        Book book = new Book("Lucky wheel", "unknown author");
        s.book = book;
        socket = new Socket(IP_ADRESS, PORT);
        oos = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
        oos.writeObject(s);
        System.out.println("Студент без книги серверу отправлен!");
        oos.writeObject(book);
        System.out.println("Отправил в догонку книжку");
        oos.close();
        socket.close();
        System.out.println("От сервера отключился");
    }
}
