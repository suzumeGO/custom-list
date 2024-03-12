import java.util.Comparator;

public interface CustomizedList<T> {
    /**
     * @return list size
     */
    int size();
    /**
     * inserts new element in the list
     * @param t element whose presence in this collection is to be ensured
     * @return true, if the element has been successfully added, otherwise - false
     */
    boolean add(T t);
    /**
     * inserts new element in the list at the specified index
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void add(int index, T element);
    /**
     * removes all elements from the list
     */
    void clear();
    /**
     * get element by index
     * @param index index of the element to return
     * @return element by given index
     */
    T get(int index);
    /**
     * Removes the first occurrence of the specified element from this list, if it is present
     * @param index the index of the element to be removed
     * @return removed element
     */
    T remove(int index);
    /**
     *
     * @param c the {@code Comparator} used to compare list elements.
     *          A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     */
    void sort(Comparator<? super T> c);
}
