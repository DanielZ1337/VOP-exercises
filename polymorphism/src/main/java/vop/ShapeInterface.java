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
public interface ShapeInterface {
    double PI = Math.PI;
    
    double getArea();

    double getCircumference();

 
//    default String getString() {
//        return "Shape: " + getClass().getSimpleName() + "\nArea=" + getArea()
//                + "\nCircum: " + getCircumference();
//
//    }
}
