import java.util.ArrayList;

public class Box_bad<T extends Fruit_bad> {
    private ArrayList<T> content;

    public Box_bad() {
        this.content = new ArrayList<T>();
    }

    public float getMassa() {
        float mas = 0.0f;
        for(int i = 0; i < content.size(); i++) {
            mas += content.get(i).getWeight();
        }
        return mas;
    }

    public void boxPut(T item) {
        content.add(item);
    }
}
