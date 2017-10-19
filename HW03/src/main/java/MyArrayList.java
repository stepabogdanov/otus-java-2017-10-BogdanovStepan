import java.util.*;

public class MyArrayList<T> implements List<T> {
    private Object[] objects;
    private T[] objectsT;

    MyArrayList (){
        objects= new Object[10];
        objectsT = (T[]) objects;
    }

    @Override
    public int size() {

        return objectsT.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < objectsT.length; i++) {
            if (objectsT[i] != null) {
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean contains(Object o) {
        for (int i=0; i<objectsT.length; i++) {
            if (o.equals(objectsT[i])) {
                return true;
            }

        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

//    @Override
//    public boolean add(T t) {
//        return false;
//    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        objectsT[index] = element;


    }

    public boolean add(T element) {
        for (int i = 0; i < objectsT.length; i++) {
            if (objectsT[i] != null) {
                objectsT[i] = element;
            } else {
                enlargeArrayToTen();
                objectsT[i+1] = element;
            }

        }
        return true;
    }

    private void enlargeArrayToTen () {
        Object[] newObjects = new Object[objects.length + 10];
        newObjects = objects;
        objects = newObjects;
        objectsT = (T[])objects;


    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

