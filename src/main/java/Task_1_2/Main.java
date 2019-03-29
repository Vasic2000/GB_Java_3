package Task_1_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main<T> {
    static Integer[] inte = {1,2,3,4,5};
    static String[] stri = {"A", "B", "C", "D", "E"};

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.makeArrayList(inte));
        System.out.println(m.makeArrayList(stri));
//  [1, 2, 3, 4, 5]
//  [A, B, C, D, E]

        m.change(inte, 2,3);
        m.change(stri, 0, 4);

        System.out.println(m.makeArrayList(inte));
        System.out.println(m.makeArrayList(stri));
//  [1, 2, 4, 3, 5]
//  [E, B, C, D, A]
    }

    public void change(T[] arr, int a, int b ) {
        T element = arr[a];
        arr[a] = arr[b];
        arr[b] = element;
    }

    public ArrayList<T> makeArrayList (T[] arr) {
        ArrayList<T> list = new ArrayList<T>(Arrays.asList(arr));
        return list;
    }
}
