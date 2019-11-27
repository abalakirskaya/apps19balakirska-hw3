package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
   private MyPredicate my_predicate;

   public FilterDecorator(SmartArray smart_array, MyPredicate my_predicate){
       super(smart_array);
//       this.base_array = (BaseArray) base_array;
       this.my_predicate = my_predicate;

    }
    private Object[] filter(Object[] arr){
       Object[] array = Arrays.copyOf(arr, arr.length);
       return Arrays.stream(array).filter(s-> my_predicate.test(s)).toArray();
    }

    @Override
    public Object[] toArray() {

       return filter(smart_array.toArray());
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator";
    }

    @Override
    public int size() {

       return smart_array.size();
    }

}
