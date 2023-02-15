/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparable;

import java.util.*;


public class Person implements Comparable<Person>{
    private String fName;
    private String lName;
    private GregorianCalendar birthDay;
    private double heigth;

    public Person(String fName, String lName, int bYear, int bMonth, int bDate, double heigth) {
        this.fName = fName;
        this.lName = lName;
        this.birthDay = new GregorianCalendar(bYear, bMonth, bDate);
        this.heigth = heigth;
    }

    @Override
    public String toString() {
        return "fName=" + fName + ", lName=" + lName + ", birthDay=" + birthDay.getTime() + ", height_" + heigth+'\n';
    }

    //Opgave 1A:
    // Der skal sorteres på efternavn. Hvis ens, skal der sorteres på fornavn.
    // Hvis det stadig er ens sorteres på fødselsdag.
    @Override
    public int compareTo(Person o) {
        if (lName.compareTo(o.lName) > 0) {
            return 1;
        } else if (lName.compareTo(o.lName) < 0) {
            return -1;
        } else {
            if (fName.compareTo(o.fName) > 0) {
                return 1;
            } else if (fName.compareTo(o.fName) < 0) {
                return -1;
            } else {
                if(birthDay.compareTo(o.birthDay) > 0){
                    return 1;
                } else if(birthDay.compareTo(o.birthDay) < 0){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList();
        list.add(new Person("A", "BB", 1980, 3, 17, 1.87));
        list.add(new Person("B", "BB", 1980, 3, 8, 1.86));
        list.add(new Person("A", "AA", 1980, 3, 9, 1.67));
        list.add(new Person("A", "BB", 1980, 3, 10, 1.67));
        list.add(new Person("A", "BB", 1980, 3, 1, 1.66));
        list.add(new Person("A", "CC", 1980, 3, 1, 1.65));
        
        System.out.println(list);
        
        Collections.sort(list);
        System.out.println("\nsorted:\n" +list);

        //Implement the compare method of Comparator (anonymous inner class in the main()-method of Person), so Persons can be sorted by their height.

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.heigth < o2.heigth){
                    return -1;
                } else if (o1.heigth > o2.heigth) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        
        // Fjern udkommenteringen, når Comparatoren er programmeret:

        System.out.println("\nsorted:\n" +list);
        
    }

    
}
