package org.example.danishisland;

public class DanishIsland {

    private String name;
    private double circumference;
    private double area;
    private int addresses;
    private int addrPerKm2;

    public DanishIsland(String name, double circumference, double area,
                        int addresses, int addrPerKm2) {
        super();
        this.name = name;
        this.circumference = circumference;
        this.area = area;
        this.addresses = addresses;
        this.addrPerKm2 = addrPerKm2;
    }

    public String getName() {
        return name;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getArea() {
        return area;
    }

    public int getAddresses() {
        return addresses;
    }

    public int getAddrPerKm2() {
        return addrPerKm2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append("\t");
        builder.append(circumference);
        builder.append("\t");
        builder.append(area);
        builder.append("\t");
        builder.append(addresses);
        builder.append("\t");
        builder.append(addrPerKm2);
        builder.append("\n");
        return builder.toString();
    }

}
