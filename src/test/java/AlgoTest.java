package test.java;


import main.java.Item;
import main.java.SortAlgos;
import main.java.SortDemoData;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;


public class AlgoTest {

    Item[] a1 = null;
    Item[] a2 = null;
    Item[] a3 = null;
    Item[] a4 = null;
    Item[] a5 = null;
    Item[] a6 = null;
    Item[] a7 = null;


    @Before
    public void setUpBefore() throws Exception {

        Integer[] array1 = {2,5,12,6,3,5435};
        Integer[] array2 = {-13,352,3,123,-23,9834,-234};
        Integer[] array3 = {123,234,43,-19,23094,43};
        Integer[] array4 = {111,123,321,342,532,4123,123};
        Integer[] array5 = {898,324,-124,324,-123,342,25,432};
        Integer[] array6 = {432908,12,123,432,123,432};
        Integer[] array7 = {123,32,21,321,43,321,123,321,523,463,234654,754,234};

        Set<Integer> s1 = new HashSet<>(Arrays.asList(2,5,12,6,3,5435));
        a1 = s1.stream().map(x -> new Item(x)).toArray(Item[]::new);

        Set<Integer> s2 = new HashSet<>(Arrays.asList(-13,352,3,123,-23,9834,-234));
        a2 = s2.stream().map(x -> new Item(x)).toArray(Item[]::new);

        Set<Integer> s3 = new HashSet<>(Arrays.asList(123,234,43,-19,23094,43));
        a3 = s3.stream().map(x -> new Item(x)).toArray(Item[]::new);

        Set<Integer> s4 = new HashSet<>(Arrays.asList(111,123,321,342,532,4123,123));
        a4 = s4.stream().map(x -> new Item(x)).toArray(Item[]::new);

        Set<Integer> s5 = new HashSet<>(Arrays.asList(898,324,-124,324,-123,342,25,432));
        a5 = s5.stream().map(x -> new Item(x)).toArray(Item[]::new);

        Set<Integer> s6 = new HashSet<>(Arrays.asList(432908,12,123,432,123,432));
        a6 = s6.stream().map(x -> new Item(x)).toArray(Item[]::new);

        Set<Integer> s7 = new HashSet<>(Arrays.asList(123,32,21,321,43,321,123,321,523,463,234654,754,234));
        a7 = s7.stream().map(x -> new Item(x)).toArray(Item[]::new);

    }

    private boolean sorted(Item[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            if (arrays[i].key > arrays[i + 1].key) {
                return false;
            }
        }
        return true;
    }




    /**
     * sameSize checks that the given array and the output array have the same size
     */
    @Test
    public void sameSize() {
        SortDemoData data = new SortDemoData();
        data.initializeArray("2 3 4");
        Item[] copyOfMyArray = new Item[data.myArray.length];
        System.arraycopy(
                data.myArray, 0, copyOfMyArray, 0, data.myArray.length);

        SortAlgos.bubbleSort(data.myArray);

        assertTrue(data.myArray.length == copyOfMyArray.length);
    }

    /**
     * emptyArray checks that the method throws a NullPointer for a given null array
     */
    @Test(expected = NullPointerException.class)
    public void emptyArray() {

        Item[] myArray = null;
        SortAlgos.bubbleSort(null);
    }

    /**
     * correctSort checks that the array is sorted correctly at the end
     */
    @Test
    public void correctSort() {
        Item [] array = new Item[3];
        array[0] = new Item(8);
        array[1] = new Item(7);
        array[2] = new Item(6);
        SortAlgos.bubbleSort(array);
        System.out.println(array[0].key);
        assertTrue(array[0].key == 6);
        assertTrue(array[1].key == 7);
        assertTrue(array[2].key == 8);
    }


    @Test
    public void insertionSortTest() {
        SortAlgos.insertionSort(a1);
        assertTrue(sorted(a1));
    }

    @Test
    public void selectionSortTest() {
        SortAlgos.selectionSort(a2);
        assertTrue(sorted(a2));
    }

    @Test
    public void mergeSortTest() {
        SortAlgos.mergeSort(a3);
        assertTrue(sorted(a3));
    }

    @Test
    public void quickSortTest() {
        SortAlgos.quickSort(a4);
        assertTrue(sorted(a4));
    }
}
