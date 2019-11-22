package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
   private BaseArray base_array;

   public FilterDecorator(SmartArray base_array, MyPredicate my_predicate){
       super(base_array);
       this.base_array = (BaseArray) base_array;
       Integer[] integers = base_array.getElements();

       int counter = 0;
       for (int n : integers){
           if (n > 0){
               counter += 1;
           }
       }
       Integer[] result = new Integer[counter];
       int i = 0;
       for (Integer n : integers){
           if (n > 0){
               result[i] = n;
               i++;
           }
       }
       this.setElements(result);


    }
}
