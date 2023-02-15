/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erso
 */
public class ShapeDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<ShapeInterface> list = new ArrayList<>();
        // Fjern udkommenteringen efterhånden som klasserne er implementeret:
        list.add(new Circle(3.4));
        list.add(new Rectangle(3.4, 4.4));
        list.add(new Ellipse(3.4, 2.7));
        list.add(new Square(3.4));
        
        System.out.println("Shapes: " + list);
    }
    
}
