package com.example.rupizzeria;

public enum Size {

    SMALL(14.99, 13.99, 15.99, 8.99),
    MEDIUM(16.99, 15.99, 17.99, 10.99),
    LARGE(18.99, 17.99, 19.99, 12.99);

    private final double deluxe;
    private final double BBQChicken;
    private final double meatzza;
    private final double buildYourOwn;

    Size(double deluxe, double BBQChicken, double meatzza, double buildYourOwn) {
        this.deluxe = deluxe;
        this.BBQChicken = BBQChicken;
        this.meatzza = meatzza;
        this.buildYourOwn = buildYourOwn;
    }

    public double getDeluxe() {
        return this.deluxe;
    }

    public double getBBQChicken() {
        return this.BBQChicken;
    }

    public double getMeatzza() {
        return this.meatzza;
    }

    public double getBuildYourOwn() {
        return this.buildYourOwn;
    }

}
