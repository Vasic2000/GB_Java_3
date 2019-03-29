
import java.util.ArrayList;
import java.util.HashMap;

public class Test {

        public static void main(String[] args) {

            Integer[] inums = {1,2,3,4,5};
            Stats<Integer> iob = new Stats<Integer>(inums);
            double resI = iob.avg();
            System.out.println(resI);

            Double[] dnums = {1.0,2.0,3.0,4.0,5.0};
            Stats<Double> dob = new Stats<Double>(dnums);
            double resD = dob.avg();
            System.out.println(resD);

//        if (iob.sameAvg(dob)) {
//            System.out.println("равны");
//        }

            ArrayList<String> al = new ArrayList<String>();
            HashMap<Integer, String> hm = new HashMap<Integer, String>();

            // Stats<String> dob1 = new Stats<String>(dnums);

//        BoxUltimate<Integer, String> box1 = new BoxUltimate<Integer, String> (555, "hello");
//        BoxUltimate<String, Integer> box2 = new BoxUltimate<String, Integer> ("hello",555);
//
//
//        box1.info();
//        int a = box1.getObj1();
//        String b = box1.getObj2();
//
//        System.out.println(a);
//        System.out.println(b);
            //Box box2 = new Box("str");

//        box1.info();
//        box2.info();
//
//        int x = 10;

//        x = x + (Integer) box1.getObj();
////        System.out.println(x);
//        if (box1 instanceof BoxUltimate) {
//            System.out.println("это тип BoxUltimate 1");
//        }
//
//        if (box2 instanceof BoxUltimate) {
//            System.out.println("это тип BoxUltimate 2");
//        }

        }
    }
