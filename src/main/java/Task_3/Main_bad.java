package Task_3;

public class Main_bad {
    public static void main(String[] args) {
        Box_bad box1 = new Box_bad();
        Box_bad box2 = new Box_bad();
        Box_bad box3 = new Box_bad();
        Box_bad box4 = new Box_bad();

        box1.boxPut(new Apple_bad());

        box2.boxPut(new Apple_bad());
        box2.boxPut(new Apple_bad());
        box2.boxPut(new Apple_bad());

        box3.boxPut(new Apple_bad());
        box3.boxPut(new Orange_bad());
        box3.boxPut(new Orange_bad());

        box4.boxPut(new Orange_bad());
        box4.boxPut(new Orange_bad());

        System.out.println(box3.getWeight());

        System.out.println(box2.compare(box4) ? "Вес коробок одинаковый" : "Вес коробок разный");

        System.out.println("Вес коробки 1 = " + box1.getWeight());
        box1.boxRePut(box2);
        System.out.println("Вес коробки 1 после досыпания из 2 = " + box1.getWeight());
    }
}
