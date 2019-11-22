package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator extends BaseArray {

    protected SmartArray smart_array;

    public SmartArrayDecorator(SmartArray smartArray) {

        this.smart_array = smartArray;
    }

}
