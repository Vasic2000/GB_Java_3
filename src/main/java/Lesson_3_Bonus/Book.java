package Lesson_3_Bonus;

import java.io.Serializable;

public class Book implements Serializable {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void info() {
        System.out.println(title + " : " + author);
    }
}
