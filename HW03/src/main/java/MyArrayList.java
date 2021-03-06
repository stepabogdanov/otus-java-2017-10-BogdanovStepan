import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> extends AbstractList<T> implements List<T> {

    private Object[] objects;
    private T[] objectsT;
    private final int DEFAULT = 10;
    int size = 0;

   MyArrayList (){

        objects= new Object[DEFAULT];
        objectsT = (T[]) objects;
    }

    @Override
    public int size() {
      return size;
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
        size++;


    }

    public boolean add(T element) {
        for (int i = 0; i <= objectsT.length; i++) {    // TODO: 19.10.17 foreach statement
            if (objectsT[i] == null) {
                objectsT[i] = element;
                size++;
                return true;
            }

            else if (i == objectsT.length-1) {
                enlargeArrayToTen();
            }

        }
        return true; // TODO: 19.10.17 check false
    }

    private boolean enlargeArrayToTen () {       // TODO: 19.10.17 must be private, more elements
        objects = new Object[objectsT.length + DEFAULT];
        System.arraycopy(objectsT,0, objects, 0,objectsT.length);
        objectsT = (T[]) objects;
        return true; // TODO: 19.10.17 check false


    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size()];
        for (int i = 0; i < size; i++) {
          objects[i] = objectsT[i];
        }
        return objects;
//        return Arrays.copyOf(objectsT, size);
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

        Iterator iterator = c.iterator();
        for (int i=0; i<= objectsT.length; i++) {

            if (!iterator.hasNext()) {
                return true;
            }
            else if (objectsT[i] == null && iterator.hasNext()) {
                objectsT[i] = (T) iterator.next();
                size++;

                if (i == objectsT.length - 1 && iterator.hasNext()) {
                    enlargeArrayToTen();
                }
            }
            else if (i == objectsT.length - 1 && iterator.hasNext()) {
                enlargeArrayToTen();
            }
        }

        return true;
    }

    public boolean addAll(Collection<? extends T> c, int numbElements) {

        Iterator iterator = c.iterator();
        for (int i=0; i<= objectsT.length; i++) {

            if (!iterator.hasNext() || numbElements == 0) {
                return true;
            }
            else if (objectsT[i] == null && iterator.hasNext() ) {
                objectsT[i] = (T) iterator.next();
                size++;
                numbElements--;

                if (i == objectsT.length - 1 && iterator.hasNext()) {
                    enlargeArrayToTen();
                }
            }
            else if (i == objectsT.length - 1 && iterator.hasNext()) {
                enlargeArrayToTen();
            }
        }

        return true;
    }

    static <T> void copy(List<? super T> dest, List<? extends T> src) {


    }



    @Override
    public Iterator<T> iterator() {
        return super.iterator();
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
    public void clear() {

    }

    @Override
    public T get(int index) {
        return objectsT[index];
    }

    @Override
    public T set(int index, T element) {
        objectsT[index] = element;
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
        ListIterator <T> listerator = new ListIterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index >=0 && index < objectsT.length && objectsT[index] != null ) { return true;}
                else return false;

            }

            @Override
            public T next() {
                int returnIndex = 0;
                if (index-1 < objectsT.length && objectsT[index] != null) {
                    returnIndex = index;
                    index++;

                }
                return objectsT[returnIndex];
            }

            @Override
            public boolean hasPrevious() {
                if (index >= 0) {return true; }
                else return false;
            }

            @Override
            public T previous() {
                return objectsT[index-1];
            }

            @Override
            public int nextIndex() {
                return index+1;
            }

            @Override
            public int previousIndex() {
                return index-1;
            }

            @Override
            public void remove() {
                objectsT[index] = null;

            }

            @Override
            public void set(T t) {
                objectsT[index-1] = t;

            }

            @Override
            public void add(T t) {
               add(t);

            }
        };


        return listerator;
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
