package testtasksort;

import org.junit.Assert;
import org.junit.Test;
import ru.skilanov.io.testtasksort.Sorter;

import static org.hamcrest.Matchers.is;

/**
 * This is test class for Sorter.
 */
public class SorterTest {

    /**
     * This is test class for straightSort method.
     */
    @Test
    public void whenWeSortArrayStraightThenReturnSortedArray() {
        String[] list = {"K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1",
                "K2", "K2\\SK1\\SSK1"};
        String[] afterSort = {"K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        Sorter sorter = new Sorter();

        String[] result = sorter.straightSort(list);

        Assert.assertThat(result, is(afterSort));
    }

    /**
     * This is test class for reverseSort method.
     */
    @Test
    public void whenWeSortArrayReverseThenReturnSortedArray() {
        String[] list = {"K2\\SK1\\SSK2", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1",
                "K2", "K2\\SK1\\SSK1"};
        String[] afterSort = {"K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2", "K1\\SK2", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1",
                "K1\\SK1"};
        Sorter sorter = new Sorter();

        String[] result = sorter.reverseSort(list);

        Assert.assertThat(result, is(afterSort));
    }
}
