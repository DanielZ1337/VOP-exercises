package vop;
public class Ellipse extends AbstractShape {
    private double r1;
    private double r2;

    public Ellipse(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }


    @Override
    public double getArea() {
        return PI * r1 * r2;
    }

    @Override
    public double getCircumference() {
        return 2 * PI * Math.sqrt(0.5 * (r1 * r1 + r2 * r2));
    }


}
