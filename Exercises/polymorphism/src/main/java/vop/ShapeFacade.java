/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stufff:
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

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    }

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        ShapeInterface currentShape;
        switch(shape){
            case CIRCLE -> {
                currentShape = new Circle(parametre[0]);
            }
            case ELLIPSE -> {
                currentShape = new Ellipse(parametre[0],parametre[1]);
            }
            case RECTANGLE -> {
                currentShape = new Rectangle(parametre[0],parametre[1]);
            }
            case SQUARE -> {
                currentShape = new Square(parametre[0]);
            }
            default -> {
                return "Shape not found";
            }
        }
        return currentShape.toString();
    }

}
