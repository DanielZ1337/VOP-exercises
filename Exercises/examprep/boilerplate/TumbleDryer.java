public class TumbleDryer implements LaundryMachine {

    private double pricePerMinute;
    private final String model;

    public TumbleDryer(String model) {
        this.model = model;
        pricePerMinute = LaundryConstants.TUMBLE_PRICE;
    }

    public void setPrice(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice(int prog) {
        return pricePerMinute * prog;
    }

    @Override
    public String getProgName(int prog) {
        return "Drying for " + prog + " minutes";
    }

    @Override
    public String toString() {
        return getModel() + " Minutpris: " + pricePerMinute + "\n";
    }

}
