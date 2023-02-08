package vop;
public class Rectangle extends AbstractShape{

    private double l1;
    private double l2;

    public Rectangle(double l1, double l2) {
        if (l1 > 0.0 && l2 > 0.0) {
            this.l1 = l1;
            this.l2 = l2;
        }
        else {
            System.out.println("Error ");
        }
    }

    @Override
    public double getArea() {
        return l1 * l2;
    }

    @Override
    public double getCircumference() {
        return 2 * (l1 + l2);
    }
    

}
