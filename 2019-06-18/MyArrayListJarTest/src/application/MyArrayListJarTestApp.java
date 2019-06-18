package application;

import model.MyArrayList;

public class MyArrayListJarTestApp {

    public static void main(String[] args) {

        MyArrayList<Integer> MyArrList = new MyArrayList<>();

        MyArrList.add(1);
        MyArrList.add(2);
        MyArrList.add(3);
        //MyArrList.trim_first();
        //MyArrList.trim_last();

        MyArrList.mark_range_as_null(1,3);
        MyArrList.input_value_in_range(0,1,"dropped");

        System.out.println(MyArrList);

    }

}
