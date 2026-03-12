public class Demo {
    public static boolean soNT(int a){
        if (a <= 1) return false;
        boolean counted = true;
        int x = a - 1;
        while (x != 1){
            if (a % x == 0){
                counted = false;
                break;
            }
            x--;
        }
        if (counted){
            return true;
        }
        return false;
    }

    public static int fibonanci(int x){
        if (x <= 0) return -1;
        if (x == 1 || x == 2) return 1;
        int fk_1 = 1;
        int fk_2 = 1;
        int fk = 0;
        for (int i = 3; i < x; i++){
            fk = fk_1 + fk_2;
            fk_1 = fk_2;
            fk_2 = fk;
        }
        return fk;
    }

//    public static void main(String[] args) {
//        System.out.println(soNT(11));
//    }
}
