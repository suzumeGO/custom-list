import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testSort() {
        QuickSort<Integer> quickSort = new QuickSort<>();
        List<Integer> unsortedList = getPreparedIntegerList();
        List<Integer> sortedList = getSortedIntegerList();

        unsortedList = quickSort.sort(unsortedList, Comparator.naturalOrder());

        Assertions.assertEquals(sortedList, unsortedList);
    }

    private List<Integer> getPreparedIntegerList() {
        List<Integer> list = new CustomizedListImpl<>();
        list.add(10);
        list.add(1);
        list.add(65);
        list.add(22);
        list.add(-5);
        return list;
    }

    private List<Integer> getSortedIntegerList() {
        List<Integer> list = new CustomizedListImpl<>();
        list.add(-5);
        list.add(1);
        list.add(10);
        list.add(22);
        list.add(65);
        return list;
    }
}