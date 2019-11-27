package ua.edu.ucu.smartarr;


// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] arr;
    public BaseArray(Object[] array){

        this.arr = new Object[array.length];
        System.arraycopy(array, 0, arr, 0, size());
    }

    public BaseArray() {
    }

    @Override
    public Object[] toArray() { //return array with SmartArray elements
        Object[] result = new Object[size()];
        System.arraycopy(arr, 0, result, 0, size());
        return result;
    }

    @Override
    public String operationDescription() { // return current operation name applied to SmartArray
        return "Base Array";
    }

    @Override
    public int size() { // return SmartArray size
        return arr.length;
    }

}