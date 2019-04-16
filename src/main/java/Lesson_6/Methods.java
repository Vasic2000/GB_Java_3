package Lesson_6;

import java.util.Arrays;

public class Methods {
//    public static void main(String[] args) {
//        Methods me = new Methods();
//        int[] aa = {1,3,4,5,6,8,3,5,3,1};
//        System.out.println(Arrays.toString(aa));
//        System.out.println(Arrays.toString(me.conTrim(aa)));
//    }


    public int[] conTrim(int[] arr) {
        int j = -1;

        for(int i = 0; i < arr.length - 1; i++)
            if (arr[i] == 4) j = i;

        if(j == -1) throw new RuntimeException("Нет 4-ок или 4-ка последняя цифра");

        int[] result = new int[arr.length - j - 1];
        for (int i = 0; i < arr.length - j - 1; i++)
            result[i] = arr[j + i + 1];

        return result;
    }

    public boolean check_1_4(int[] arr) {
        return true;
    }

}
