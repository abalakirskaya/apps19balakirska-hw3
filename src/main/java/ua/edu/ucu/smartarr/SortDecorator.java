package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

public class SortDecorator extends SmartArrayDecorator{
    private BaseArray base_array;

    public SortDecorator(SmartArray base_array,  MyComparator myComparator) {
        super(base_array);
        this.base_array = (BaseArray) base_array;
        Integer[] integers = base_array.getElements();
        Arrays.sort(integers, myComparator);
        this.setElements(integers);
    }

}