package vop;

public class Ellipse extends AbstractShape {

    protected double r1;
    protected double r2;

    Ellipse(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double getArea() {
        return PI * r1 * r2;
    }

    @Override
    public double getCircumference() {
        return 2 * PI * Math.sqrt(0.5 * (Math.pow(r1, 2) + Math.pow(r2, 2)));
    }
}
