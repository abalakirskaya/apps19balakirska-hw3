package ua.edu.ucu;

import java.util.ArrayList;
import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
       MyPredicate pred = new MyPredicate() {
           @Override
           public boolean test(Object t) {
               int year = 2;
               int min_GPA = 4;
               Student student = (Student) t;
               return (student.getGPA() >= min_GPA && student.getYear() == year);
           }
       };

       MyComparator comp = new MyComparator() {
           @Override
           public int compare(Object o1, Object o2) {
               Student first_st = (Student) o1;
               Student second_st = (Student) o2;
               return (first_st.getSurname().compareTo(second_st.getSurname()));
           }
       };

       MyFunction function = new MyFunction() {
           @Override
           public Object apply(Object t) {
               Student student = (Student) t;
               return student.getSurname() + " " + student.getName();
           }
       };

       SmartArray smartArray = new BaseArray(students);
       smartArray = new FilterDecorator(smartArray, pred);
       smartArray = new SortDecorator(smartArray, comp);
       smartArray = new MapDecorator(smartArray, function);
       smartArray = new DistinctDecorator(smartArray);
       Object[] students_result = smartArray.toArray();
       return Arrays.stream(students_result).toArray(String[]::new);
    }
}
