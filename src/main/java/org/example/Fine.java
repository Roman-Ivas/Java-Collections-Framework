package org.example;

public class Fine {
    private String type;
    private double amount;

    public Fine(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
