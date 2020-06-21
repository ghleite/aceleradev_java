package br.com.codenation.paymentmethods;

public class DebitCard implements PriceStrategy{

    private final double DISCOUNT = 0.95;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}