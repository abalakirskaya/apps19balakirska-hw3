package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyFunction;
// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private BaseArray base_array;

    public MapDecorator(SmartArray base_array, MyFunction my_function){
        super(base_array);
        this.base_array = (BaseArray) base_array;
        Integer[] integers = base_array.getElements();
        int counter = 0;
        for (Integer el: integers) {
            integers[counter] = (Integer) my_function.apply(el);
            counter++;
        }

        this.setElements(integers);
    }
}
