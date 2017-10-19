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
        for (int i = 0; i < objectsT.length; i++) { // TODO: 19.10.17 foreach statement
            if (objectsT[i] != null) {
                return false;
            }
        }
    return true;
    }

    @Override
    public boolean contains(Object o) {
        o = (T) o;

        for (int i=0; i<objectsT.length; i++) {            // TODO: 19.10.17 foreach statement
            if (objectsT[i] != null && objectsT[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(int index, T element) {
        objectsT[index] = element;


    }

    public boolean add(T element) {
        for (int i = 0; i <= objectsT.length; i++) {    // TODO: 19.10.17 foreach statement
            if (objectsT[i] == null) {
                objectsT[i] = element;
                return true;
            }

            else if (i == objectsT.length-1) {
                enlargeArrayToTen();
            }

        }
        return true; // TODO: 19.10.17 check false
    }

    public boolean enlargeArrayToTen () {       // TODO: 19.10.17 must be private, more elements
//        Object[] objectBuff = new Object[objectsT.length + 10];
        objects = new Object[objectsT.length + 10];
        System.arraycopy(objectsT,0, objects, 0,objectsT.length);
        objectsT = (T[]) objects;
        return true; // TODO: 19.10.17 check false


    }

    @Override
    public Object[] toArray() {
        return objectsT;
    }

    @Override
    public boolean remove(Object o) {
        o = (T) o;

        for (int i=0; i<objectsT.length; i++) {            // TODO: 19.10.17 foreach statement
            if (objectsT[i] != null && objectsT[i].equals(o)) {
                objectsT[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
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

