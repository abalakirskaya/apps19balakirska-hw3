package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

public class SortDecorator extends SmartArrayDecorator{
    private MyComparator my_comparator;

    public SortDecorator(SmartArray smart_array,  MyComparator my_comparator) {
        super(smart_array);
       this.my_comparator = my_comparator;
    }

    private Object[] sorting(Object[] arr){
        Object[] array = Arrays.copyOf(arr, arr.length);
        Arrays.sort(array, my_comparator);
        return array;
    }


    @Override
    public Object[] toArray() {
        return sorting(smart_array.toArray());
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator";
    }

    @Override
    public int size() {
        return smart_array.size();
    }
}