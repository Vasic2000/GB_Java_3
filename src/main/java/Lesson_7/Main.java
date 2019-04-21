package Lesson_7;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class c = URLClassLoader.newInstance(new URL[]{new File("E:/GB_Java_3").toURL()})
                .loadClass("WhatCheck");

        Field[] fields = c.getFields();
        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
            m.setAccessible(true);
            String st = m.getName();
            switch (st) {
                case "isPositive":
                    System.out.println(st);
                    boolean t1 = (boolean) m.invoke(c, 10);
                    boolean t2 = (boolean) m.invoke(c, -10);
                    if (t1 && !t2)
                        System.out.println("Тест пройден");
                    else
                        System.out.println("Тест провален");
                    break;
                case "isNegative":
                    System.out.println(st);
                    boolean t3 = (boolean) m.invoke(c, 10);
                    boolean t4 = (boolean) m.invoke(c, -10);
                    if (!t3 && t4)
                        System.out.println("Тест пройден");
                    else
                        System.out.println("Тест провален");
                    break;
//                case "printIsPositive" :
//                    System.out.println(m.invoke(c, 9));
//                    System.out.println(st);
//                    String st1 = (String) m.invoke(c, 9);
//                    String st2 = (String) m.invoke(c, -1);
//                    String st3 = (String) m.invoke(c, 0);
//                    if(st1.equals("Your number is positive!") && st2.equals("Your number is negative!") &&
//                            st3.equals("Your number is positive!"))
//                        System.out.println("Тест пройден");
//                    else
//                        System.out.println("Тест провален");
//                    break;
                case "checkTwoNumbers" :
                    System.out.println(st);
                    boolean t5 = (boolean) m.invoke(c, 10,30);
                    boolean t6 = (boolean) m.invoke(c, 10,5);
                    if (!t5 && t6)
                        System.out.println("Тест пройден");
                    else
                        System.out.println("Тест провален");
                    break;
//                case "printWelocome" :
//                    System.out.println(st);
//                    m.invoke(c, "N");
//                    break;
                case "isLeapYear" :
                    System.out.println(st);
                    boolean t7 = (boolean) m.invoke(c, 1999);
                    boolean t8 = (boolean) m.invoke(c, 2000);
                    boolean t9 = (boolean) m.invoke(c, 1800);
                    if(!t7 && t8 && !t9)
                        System.out.println("Тест пройден");
                    else
                        System.out.println("Тест провален");
                    break;
                case "calculate" :
                    System.out.println(st);
                    if(m.invoke(c, 1,2,4,2) instanceof Integer) {
                        Integer ins1 = (int) m.invoke(c, 1,2,4,2);
                        Integer ins2 = (int) m.invoke(c, 3,2,4,2);
                        if((ins1 == 4) && (ins2 == 12))
                            System.out.println("Тест пройден");
                        else
                            System.out.println("Тест провален");
                        break;
                    }
                    if(m.invoke(c, 1,2,4,2) instanceof Float) {
                        Float flo1 = (float) m.invoke(c, 1, 2, 4, 2);
                        Float flo2 = (float) m.invoke(c, 3, 2, 4, 2);
                        if ((flo1 == 4.0f) || (flo2 == 12.0f))
                            System.out.println("Тест пройден");
                        else
                            System.out.println("Тест провален");
                        break;
                    }
                default:
                    System.out.println(st);
                    System.out.println("Не тестировал");
            }
        }
    }
}
