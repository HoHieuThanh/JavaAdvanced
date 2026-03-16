package ex3;

public interface CardPayable extends PaymentMethod {

    void processCreditCard(double amount);
}
