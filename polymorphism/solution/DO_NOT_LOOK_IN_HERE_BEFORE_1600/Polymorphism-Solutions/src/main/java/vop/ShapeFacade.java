package vop;

public class ShapeFacade {

    //Singleton Stuff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {
    }
    //---------------------------

    public enum SHAPES{CIRCLE, ELLIPSE, RECTANGLE, SQUERE}

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        ShapeInterface currentShape;
        switch (shape) {
            case CIRCLE -> currentShape = new Circle(parametre[0]);
            case ELLIPSE -> currentShape = new Ellipse(parametre[0], parametre[1]);
            case SQUERE -> currentShape = new Square(parametre[0]);
            case RECTANGLE -> currentShape = new Rectangle(parametre[0], parametre[1]);
            default -> {
                return "Unknown Shape";
            }
        }
        return currentShape.toString();
    }
    
 

}
