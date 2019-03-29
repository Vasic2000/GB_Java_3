package Task_3;

import java.util.ArrayList;

public class Box_bad<T extends Fruit_bad> {
    private ArrayList<T> content;

    public Box_bad() {
        this.content = new ArrayList<T>();
    }

    public float getWeight() {
        float mas = 0.0f;

        //Способ из условия
        float mas2 = content.get(0).getMassa() * content.size();

        //Чесный способ, вдруг в коробке разное
        for(int i = 0; i < content.size(); i++) {
            mas += content.get(i).getMassa();
        }

        if(mas == mas2) return mas;
        else {
            System.out.println("Законы физики нарушены (((");
            return -1.0f;
        }
    }

    public boolean compare(Box_bad another) {
        return this.getWeight() == another.getWeight();
    }

    public void boxPut(T item) {
        //Если коробка пустая - кладу что угодно
        if(content.isEmpty())
            content.add(item);
        //Если в коробке хоть одино яблоко - кладу только яблоки
        else if((content.get(0) instanceof Apple_bad) && (item instanceof Apple_bad))
            content.add(item);
        //Если в коробке хоть один апельсин - только апельсины
        else if((content.get(0) instanceof Orange_bad) && (item instanceof Orange_bad))
            content.add(item);
    }

    public void boxRePut(Box_bad<T> box) {
        if(((content.get(0) instanceof Apple_bad) && (box.content.get(0) instanceof Apple_bad)) ||
                ((content.get(0) instanceof Apple_bad) && (box.content.get(0) instanceof Apple_bad))) {
            for (int i = 0; i < box.content.size(); i++)
                content.add(box.content.get(i));
            for (int i = 0; i < box.content.size(); i++)
                box.content.remove(i);
        }
    }
}
