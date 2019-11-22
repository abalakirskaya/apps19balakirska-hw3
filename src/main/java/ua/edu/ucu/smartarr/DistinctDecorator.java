package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    private MyPredicate my_predicate;

    public DistinctDecorator(SmartArray smart_array, MyPredicate my_predicate) {
        super(smart_array);
        this.my_predicate = my_predicate;

    }



}