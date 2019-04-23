package Lesson_7.gb;

@Xtype
public class Cat {

    private final String name;

    @MyAnon(priority = 7)
    public int age;

    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getColor() {
        return color;
    }

    public void test1() {
        System.out.println("test1");
    }


    public void test2() {
        System.out.println("test2");
    }

    public void info1() {
        System.out.println(name + " " + color + " " + age);
    }

    private void info2() {
        System.out.println(name + " " + color + " " + age);
    }
}
