package Lesson_7.gb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        String str = "Java";
//        Class strClass = str.getClass();
//        System.out.println(strClass);

//        Class c = Cat.class;
//        Field[] fields = c.getDeclaredFields();
//
//        for (Field o : fields) {
//            System.out.println(o);
//        }

//        Cat cat = new Cat("Barsik", 2, "White");
//        Class c = Cat.class;
//        cat.info1();
//        Field f = c.getDeclaredField("name");
//        f.setAccessible(true);
//        f.set(cat, "newName");
//        cat.info1();

//        Class ch = URLClassLoader.newInstance(new URL[]{new File("C:/0123")
//                .toURL()}).loadClass("Human");
//
//        Constructor constructor = ch.getConstructor(String.class);
//
//        Object human = constructor.newInstance("Bob");
//
//        Method m = ch.getDeclaredMethod("info");
//
//        m.invoke(human);

//        File file = new File("C:/123");
//
//        String[] str = file.list();
//
//        for (String o : str) {
//            String[] mass = o.split("\\.");
//            if(!mass[1].equalsIgnoreCase("class")) {
//                throw new RuntimeException(o, new Exception());
//            }
//        }

        Class c = Cat.class;
        Cat cat = new Cat("C", 10, "r");
        Method[] methods = c.getDeclaredMethods();
        for (Method o: methods) {
            if(o.isAnnotationPresent(MyAnon.class)) {
                System.out.println(o.getAnnotation(MyAnon.class).priority());
                o.invoke(cat);
            }
        }

    }
}


