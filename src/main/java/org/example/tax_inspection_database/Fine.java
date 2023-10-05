package org.example.tax_inspection_database;

public class Fine {
    private final String type;
    private final double amount;
    private final String city;

    public Fine(String type, double amount, String city) {
        this.type = type;
        this.amount = amount;
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount + ", City: " + city;
    }
}
