import java.util.ArrayList;
import java.util.List;

public class GenericStorage<T> {
    private final List<T> elements = new ArrayList<>();

    public void addElement(T o) {
        elements.add(o);
    }

    public T removeElement(int index) {
        return elements.remove(index);
    }

    public T getElement(int index) {
        return elements.get(index);
    }

    public int getSize() {
        return elements.size();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}