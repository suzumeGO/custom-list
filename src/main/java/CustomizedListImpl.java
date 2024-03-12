import java.util.*;
import java.util.function.Consumer;

public class CustomizedListImpl<E> extends AbstractList<E> implements CustomizedList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int size;

    public CustomizedListImpl() {
        data = new Object[INITIAL_CAPACITY];
    }

    public CustomizedListImpl(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    /**
     * Performs the action for each element in the list.
     * @param action The action to be performed for each element
     */
    @Override
    public void forEach(Consumer<? super E> action) {
        for (int i = 0; i < size; i++) {
            action.accept((E) data[i]);
        }
    }

    /**
     *
     * @return list size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Add the element to the end of the list. If list reaches max size, size will be increased by 1.5 times.
     * Increase size by 1.
     * @param e element whose presence in this collection is to be ensured
     * @return true if list was modified
     */
    @Override
    public boolean add(E e) {
        if (size == data.length) {
            grow();
        }
        data[size] = e;
        size = size + 1;
        return true;
    }

    private void grow() {
        data = Arrays.copyOf(data, data.length * 3 / 2);
    }

    /**
     * Add the element to the given position. If index out of bounds, throws an exception.
     * If position == list size, the element is inserted in the end of the list.
     * Increase size by 1.
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == data.length) {
            grow();
        }
        data = insertElement(data, index, element);
        size = size + 1;
    }

    private Object[] insertElement(Object[] src, int index, E newElement) {
        Object[] dst = new Object[src.length + 1];
        int j = 0;
        for (int i = 0; i < dst.length - 1; i++) {
            if (i == index) {
                dst[i] = newElement;
            } else {
                dst[i] = src[j];
                j++;
            }
        }
        return dst;
    }

    /**
     * Replace old data by new empty array with size == 0.
     */
    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * If index out of bounds, throws an exception.
     * @param index index of the element to return
     * @return an element by given index.
     */
    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    /**
     * Remove the element at the given index.
     * Decrease size by 1.
     * If index out of bounds, throws an exception.
     * @param index the index of the element to be removed
     * @return removed element
     */
    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E removedElement = get(index);
        data = removeElement(data, index);
        size = size - 1;
        return removedElement;
    }

    private Object[] removeElement(Object[] src, int index) {
        Object[] dst = new Object[src.length - 1];
        System.arraycopy(src, 0, dst, 0, index);
        System.arraycopy(src, index + 1,
                dst, index,
                src.length - index - 1);
        return dst;
    }

    /**
     * Sorts elements in the list.
     * @param c the {@code Comparator} used to compare list elements.
     *          A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     */
    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) data,0, size, c);
    }

}
