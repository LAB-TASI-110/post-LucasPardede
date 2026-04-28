package model;

public class City {
    private final String code;
    private final String name;
    private final double pricePerKg;
    private final boolean isOuterIsland;

    public City(String code, String name, double pricePerKg, boolean isOuterIsland) {
        this.code = code;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.isOuterIsland = isOuterIsland;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPricePerKg() { return pricePerKg; }
    public boolean isOuterIsland() { return isOuterIsland; }
}