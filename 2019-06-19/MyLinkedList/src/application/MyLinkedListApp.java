package application;

import model.MyLinkedList;

public class MyLinkedListApp {

    public static void main(String[] args) {

        MyLinkedList<Integer> mlli = new MyLinkedList<>();

        mlli.add(3);
        //System.out.println(mlli);

        mlli.add(11);
        //System.out.println(mlli);

        mlli.addLast(-8);
        //System.out.println(mlli);

        mlli.addFirst(4);
        //System.out.println(mlli);

        mlli.addFirst(-2);
        //System.out.println(mlli);

        mlli.addFirst(6);
        //System.out.println(mlli);

        mlli.addByIndex(3,111);
        System.out.println(mlli);

        //mlli.removeFirst();
        //System.out.println(mlli.removeFirst());
        //System.out.println(mlli);
       // mlli.removeLast();

        //System.out.println(mlli.removeLast());

        //System.out.println(mlli.indexOf(-8));

        mlli.removeByIndex(6);

        //mlli.eliminateAll();

        System.out.println(mlli);



    }

}
