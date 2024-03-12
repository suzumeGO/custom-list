import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSort<E> {
    /**
     * Method to sort the objects in list using quick sort algorithm
     * @param objects - list of objects to sort
     * @param comparator - comparator for sort
     * @return sorted list
     */
    public List<E> sort(List<E> objects, Comparator<E> comparator) {
        if (objects.size() < 2) {
            return objects;
        }
        E median = objects.stream().findAny().get();
        List<E> lower = sort(objects.stream().filter(o -> comparator.compare(o, median) < 0).toList(), comparator);
        List<E> higher = sort(objects.stream().filter(o -> comparator.compare(o, median) > 0).toList(), comparator);
        List<E> result = new ArrayList<>(lower);
        result.add(median);
        result.addAll(higher);
        return result;
    }

}
