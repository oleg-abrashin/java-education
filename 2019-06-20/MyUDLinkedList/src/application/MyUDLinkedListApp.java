package application;

import model.MyUDLinkedList;

public class MyUDLinkedListApp {

    public static void main(String[] args) {

        MyUDLinkedList<Integer> mlli = new MyUDLinkedList<>();
        System.out.println(mlli);

        mlli.add(3);
        System.out.println(mlli);

        mlli.add(11);
        System.out.println(mlli);

        mlli.addLast(-8);
        System.out.println(mlli);

        mlli.addFirst(4);
        System.out.println(mlli);

        mlli.addFirst(-2);
        System.out.println(mlli);

        mlli.addFirst(6);
        System.out.println(mlli);

        mlli.addByIndex(4,111);
        System.out.println(mlli);

        mlli.removeFirst();
        System.out.println(mlli);

        mlli.removeLast();
        System.out.println(mlli);

        mlli.removeLast();
        System.out.println(mlli);

        System.out.println(mlli.remove(222));

        mlli.eliminateAll();
        System.out.println(mlli);

    }

}
