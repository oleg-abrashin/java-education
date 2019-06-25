package application;

public class MemoryLimitApp {

    public static void main(String[] args) {
        int[] arr;
        int left = 0;
        int right = Integer.MAX_VALUE;
        try {
            arr = new int[right];
            System.out.println("No limit");
            return;
        } catch (Error e){
            //System.out.println("Error e");
        }

        int middle = 0;
        while(right - left > 1){
            arr = null;
            middle = left + (right-left)/2;

            try{
                arr = new int[middle];
                left = middle;
                arr = new int[middle];
            } catch (Error e){
                right = middle;
            }

        }


        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024); // количество свободной памяти, доступной приложению
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);  // количество памяти, выделенной приложению


        //System.out.println((double)left*4/1024/1024);

    }

}
