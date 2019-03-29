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
        box3.boxPut(new Orange_bad());

        float p = box3.getMassa();
        System.out.println(p);
    }
}
