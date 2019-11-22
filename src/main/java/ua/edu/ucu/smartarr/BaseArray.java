package ua.edu.ucu.smartarr;


// Base array for decorators
public class BaseArray implements SmartArray {
    private Integer[] integer_elements;
    public BaseArray(Integer[] ints){
        this.integer_elements = ints;
    }

    public BaseArray() {
    }

    @Override
    public Object[] toArray() { //return array with SmartArray elements
        return this.getElements();
    }

    @Override
    public String operationDescription() { // return current operation name applied to SmartArray
        return "Smart Array";
    }

    @Override
    public int size() { // return SmartArray size
        return integer_elements.length;
    }

    public Integer[] getElements() {
        return integer_elements;
    }

    public void setElements(Integer[] new_integers) {
        this.integer_elements = new_integers;
    }
}