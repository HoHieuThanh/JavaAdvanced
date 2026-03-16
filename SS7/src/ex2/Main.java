package ex2;

public class Main {

    public static void main(String[] args) {

        double total = 1000000;

        // Giảm 10%
        OrderCalculator calc1 =
                new OrderCalculator(new PercentageDiscount(10));

        System.out.println("Số tiền sau giảm: "
                + calc1.calculateFinalAmount(total));

        // Giảm cố định 50.000
        OrderCalculator calc2 =
                new OrderCalculator(new FixedDiscount(50000));

        System.out.println("Số tiền sau giảm: "
                + calc2.calculateFinalAmount(total));

        // Không giảm
        OrderCalculator calc3 =
                new OrderCalculator(new NoDiscount());

        System.out.println("Số tiền sau giảm: "
                + calc3.calculateFinalAmount(total));

        // Holiday discount 15%
        OrderCalculator calc4 =
                new OrderCalculator(new HolidayDiscount());

        System.out.println("Số tiền sau giảm: "
                + calc4.calculateFinalAmount(total));
    }
}
