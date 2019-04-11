package Lesson_5.HELP;

public class Test {
}



// 1
class A {
    public static void main(String[] args) {
        for (byte i = 0; ++i > 0; ) {
            System.out.println(i);
        }
    }
}




















// 2
class B {
    int i = getInt();
    int k = 20;
    public int getInt() {
        return k + 1;
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.i + " " + b.k);
    }
}

















// 3
class C {
    public void process() {
        System.out.println("C ");
    }
}

class D extends C {
    public void process() throws RuntimeException {
        super.process();
        if(true) throw new RuntimeException();
        System.out.println("D ");
    }

    public static void main(String[] args) {
        try {
            ((C)new D()).process();
        } catch (Exception e) {
            System.out.println("Exception print");
        }
    }
}



















// 4

class E {
    public static void main(String[] args) {
        System.out.println((-(byte)128)>> 1 == 128 >> 1);
        System.out.println(128 >> 1);
    }
}




























//5
// Скомпилируется ли код? и какой результат?

//class F {
//    public static void main(String[] args) {
//        Map<String, Integer> map1 = new HashMap<String, Integer>();
//        Map<String, Integer> map2 = new HashMap<String, Integer>();
//
//        map1.put("Number1", new Integer(100));
//        map1.put("Number2", new Integer(200));
//        map1.put("Number3", new Integer(300));
//
//        List<Map> list = new ArrayList<Map>();
//        list.add(map1);
//        list.add(map2);
//
//        HashMap resultMap = (HashMap) list.get(0);
//        System.out.println("Num " + resultMap.get("Number2"));
//    }
//}
