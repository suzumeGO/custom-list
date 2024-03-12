import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class CustomizedListImplTest {

    @Test
    void testSize() {
        int actualEmptySize = getEmptyIntegerList().size();
        int expectedEmptySize = 0;
        int actualPreparedSize = getPreparedIntegerList().size();
        int expectedPreparedSize = 5;

        Assertions.assertEquals(expectedEmptySize, actualEmptySize);
        Assertions.assertEquals(expectedPreparedSize, actualPreparedSize);
    }
    @Test
    void testAdd() {
        List<Integer> list = getEmptyIntegerList();

        list.add(11);

        Assertions.assertNotNull(list.size());
        Assertions.assertEquals(11, list.get(0));
    }
    @Test
    void testAddWithIndexInsideBounds() {
        List<Integer> list = getPreparedIntegerList();
        int pos = list.size() - 2;
        int expectedValue = 11;

        list.add(pos, 11);
        int actualValue = list.get(pos);

        Assertions.assertEquals(expectedValue, actualValue);
    }
    @Test
    void testAddWithIndexBeyondUpperBound() {
        List<Integer> list = getPreparedIntegerList();
        int pos = list.size() + 2;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.add(pos, 11));
    }
    @Test
    void testAddWithIndexBeyondLowerBound() {
        List<Integer> list = getPreparedIntegerList();
        int pos = -1;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.add(pos, 11));
    }
    @Test
    void testClear() {
        List<Integer> list = getPreparedIntegerList();
        int expectedSize = 0;

        list.clear();
        int actualSize = list.size();

        Assertions.assertEquals(expectedSize, actualSize);
    }
    @Test
    void testGet() {
        List<Integer> list = getEmptyIntegerList();

        list.add(11);

        Assertions.assertNotNull(list.get(0));
    }
    @Test
    void testRemove() {
        List<Integer> list = getPreparedIntegerList();
        int expected = list.get(1);

        list.remove(0);
        int actual = list.get(0);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testRemoveWithIndexBeyondLowerBound() {
        List<Integer> list = getPreparedIntegerList();
        int pos = -1;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.remove(pos));
    }
    @Test
    void testRemoveWithIndexBeyondUpperBound() {
        List<Integer> list = getPreparedIntegerList();
        int pos = list.size() + 2;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.remove(pos));
    }

    @Test
    void testSort() {
        List<Integer> list = getPreparedIntegerList();
        List<Integer> sortedList = getSortedIntegerList();

        list.sort(Comparator.naturalOrder());

        Assertions.assertEquals(sortedList, list);
    }


    private List<Integer> getEmptyIntegerList() {
        return new CustomizedListImpl<>();
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