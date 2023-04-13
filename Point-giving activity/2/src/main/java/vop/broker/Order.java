package vop.broker;

import vop.Symbol;

public class Order {

    private final int units;
    private final Symbol symbol;
    private double pricePerUnit;
    private OrderStatus status = OrderStatus.Placed;

    public Order(Symbol symbol, int units) {
        this.symbol = symbol;
        this.units = units;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getUnits() {
        return units;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
