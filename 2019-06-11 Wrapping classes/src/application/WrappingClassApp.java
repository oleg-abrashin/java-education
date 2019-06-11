package application;

public class WrappingClassApp {
    public static void main(String[] args) {

        //ручной инбоксинг

        int i = 3;

        Integer ii = new Integer(i);

        Integer jj = i;

        Integer kk = (Integer) i; // принудительное преобразование

        System.out.println(ii);
        System.out.println(jj);
        System.out.println(kk);

        // ручной аутбоксинг
        int value = ii;

        System.out.println(value);

        Integer aa = 55;
        Integer bb = 9;
        System.out.println(aa > bb);

        Integer xx = new Integer("123");
        System.out.println(xx);

        String str = "sasha";
        System.out.println(Integer.parseInt(str, 36));

        Integer zz = 777;
        System.out.println(zz.toString());
        System.out.println(Integer.toString(zz));
        System.out.println(Integer.toString(zz, 16));
        System.out.println(Integer.toBinaryString(zz));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);



    }
}
