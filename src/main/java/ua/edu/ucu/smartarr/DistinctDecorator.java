package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.LinkedHashSet;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smart_array) {
        super(smart_array);
    }

    private Object[] distinctArray(Object[] arr){
        Object[] array = Arrays.copyOf(arr, arr.length);
        return Arrays.stream(array).distinct().toArray();
    }


    @Override
    public Object[] toArray() {
        return distinctArray(smart_array.toArray());
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator";
    }

    @Override
    public int size() {
        return smart_array.size();
    }
}