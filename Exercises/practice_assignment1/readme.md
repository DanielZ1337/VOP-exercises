# Practice Assignment 1

## Task 1a: Student implements Comparable\<Student\>

Assume, you are learning Java. You are introduced to the concepts of Comparable and Comparator interfaces. You need to practice these concepts and compare objects using both interfaces. Considering yourself a student, who needs to master these concepts, you decided to implement a student class such that you can compare student objects using both interfaces.

A class called `Student.java` is already created in the package _student\_information_. Complete the implementation of the class. Remember to use correct access modifiers for variables and methods.

- Declare 5 variables for `name(String)`, `age(int)`, `department(String)`, `result(String)`, `marks(double)`.
- Create a Constructor to initialize the 5 variables.
- Implement 5 `Getter` methods for retrieving the values of all the 5 variables. A `Getter` method should return the value of the variable.
- Implement a `compareTo()` method, i.e., compare the `marks` of two `Student` objects. Remember to use the corresponding `Getter` methods for this implementation.
- A `toString()` method is already provided to print the students information. Uncomment it after completing the points above.
- In the `main()` method, implement the following:
    - Create a `Set` of type `Student`, called `studentSet1` and initialize it as a `TreeSet`.
    - Create 5 student objects with the following data:


```markdown
| name | age | dept | result | marks |
|------|-----|------|--------|-------|
| Tim  | 20  | me   |  pass  | 9,80  |
| Bo   | 21  | me   |  pass  | 9,20  |
| Ella | 19  | ece  |  fail  | 3,20  |
| Emma | 19  | ece  |  pass  | 9,60  |
| Paul | 20  | cse  |  pass  | 8,60  |

---------------------------------------------

"Tim", 20, "me", "pass", 9.80
"Bo", 21, "me", "pass", 9.20
"Ella", 19, "ece", "fail", 3.20
"Emma", 19, "ece", "pass", 9.60
"Paul", 20, "ece", "pass", 8.60
```
- Add student objects to the set `studentSet1` using the `add()` method.
- Print all elements inside the object `studentSet1`.
- Run and test your implementation.

**Example** of correct output, when sorting based on **marks**:

```
[ Ella   19   ece   fail   3,20
, Paul   20   cse   pass   8,60
, Bo     21   me    pass   9,20
, Emma   19   ece   pass   9,60
, Tim    20   me    pass   9,80
]
```

## Task 1b: Sorting with Comparator

- Create a class `AgeComparator.java` with the signature `public class AgeComparator implements Comparator<Student>` in the _student\_information_ package.

- Implement the `compare()` method such that it compares two `Student` objects by their `age` values and if two objects have the same `age`, they should be compared by their `marks` values. (**Hint**: Remember to use the corresponding `Getter` methods in the `Student` object.

- In the `main()` method of the `Student` class:
    - Creating another set `studentSet2` of type `Student` with reference to `TreeSet<>(new AgeComparator())`
    - Add the elements of `studentSet1` to `studentSet2` using the `addAll()` method.
    - Print all elements inside the object `studentSet2`.

- Run and test your implementation.

**Example** of correct output when sorting based on **age**:

```
[ Ella   19   ece   fail    3,20
, Emma   19   ece   pass    9,60
, Paul   20   cse   pass    8,60
, Tim    20   me    pass    9,80
, Bo     21   me    pass    9,20
]
```
