package model;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeSetTest {

    MyTreeSet<Integer> mtsi = new MyTreeSet<Integer>(Comparator.naturalOrder());
    ArrayList<Integer> data = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        data.add(25);
//        data.add(10);
//        data.add(31);
//        data.add(8);
//        data.add(24);
//        data.add(9);
//        data.add(3);
//        data.add(12);
//        data.add(4);
//        data.add(86);
//        data.add(40);
//        data.add(97);
//        data.add(39);
//        data.add(59);
//        data.add(99);
//        data.add(38);

        for (Integer i :
                data) {
            mtsi.add(i);
        }
        Collections.sort(data);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        int rm;
        ArrayList<Integer> res = new ArrayList<>();

//        for (int i = 0; i < data.size(); i++) {
//
//        }

        rm = 25;

        data.remove((Integer) rm);
        mtsi.remove(rm);

        Iterator<Integer> iterator = mtsi.iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }

        assertTrue(data.equals(res));

    }
}