package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction my_function;

    public MapDecorator(SmartArray smart_array, MyFunction my_function){
        super(smart_array);
        this.my_function = my_function;
    }

    private Object[] maping(Object[] arr){
        Object[] array = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < array.length; i++){
            array[i] = my_function.apply(array[i]);
        }
        return array;
    }

    @Override
    public Object[] toArray() {
        return maping(smart_array.toArray());
    }

    @Override
    public String operationDescription() {
        return "Map Decorator";
    }

    @Override
    public int size() {
        return smart_array.size();
    }
}
