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
public abstract class AbstractShape implements ShapeInterface{

    @Override
    public String toString() {
        String result = String.format("\nJeg er en %1s med\nAreal %2$7.3f og\nOmkreds %3$7.3f", 
                getClass().getSimpleName(), getArea(), getCircumference());
        return result;
    }
}
