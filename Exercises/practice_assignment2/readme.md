# Practice Assignment 2

You are the person responsible for recruiting new actors in Hollywood. As you also happen to be a gifted java developer, you conclude that you can make recruitment better and easier by creating a program that can save the candidates to a text file, and later retrieve their information.

You are provided two classes `Actor.java` and `Helpers.java` in the package `actor_details`.

## Task 2a

Complete the implementation of `Actor.java`. Remember to use the correct access modifiers for variables and methods.

- Declare 3 variables:

  - `name(String)`
  - `age(int)`
  - `hasBeenInterviewed(boolean)`

- Create a constructor to initialize the 3 variables. 

- Implement 3 `getter` methods for all the variables.

- Implement and override the `toString` method, and use the `getter` methods in the `toString()` to print the actors information.

- Implement the `main()` method:
  - Create 3 `Actor` objects with the following data:
  - ```
    Ryan Reynolds		46	false
    Leonardo DiCaprio	48	false
    Tom Holland		26	true
    ```
  - Create an `ArrayList` of the type `Actor`.
  - Add the `Actor` objects to the `ArrayList`.
  - Print the `ArrayList` to check your implementation.

**Example** of correct output:

```
{ name='Ryan Reynolds', age='46', hasBeenInterviewed='false'}
{ name='Leonardo DiCaprio', age='48', hasBeenInterviewed='false'}
{ name='Tom Holland', age='26', hasBeenInterviewed='true'}
```

## Task 2b

Complete the implementation of `Helpers.java` file.

Implement `writeToFile(ArrayList<Actor> actorList)` method:
- Use a `PrintWriter/FileWriter` or similar to write to the file `Actors.txt`.
- Iterate over all objects in the `actorList` and write each object to the file, using the `toString` method.
- Use the`try-with-resources` or ensure that you enclose the output stream in a `try – catch` clause and close your output stream after use.
- Make sure to catch the relevant exceptions that can be thrown.

Implement `readFromFile(String inputFile)` method:
- Read from an input file given as `inputFile` using a `Scanner` or `FileReader`
- Iterate over the contents of the file and print it out to the screen.
- Use the`try-with-resources` or ensure that you enclose the output stream in a `try – catch` clause and close your output stream after use.
- Make sure to catch the relevant exceptions that can be thrown.

Implement `checkHasBeenInterviewed(String inputFile)` method

- Read from an input file given as `inputFile` using a `Scanner` or `FileReader`
- Iterate over the contents of the file and only print those actors who have been interviewed (`hasBeenInterviewed=true`).
  - ***Hint:*** *You can use `.split(",")` to split the line on every comma "," and then save it to a `String[]` and check that array for the interview condition.*
- Use the`try-with-resources` or ensure that you enclose the output stream in a `try – catch` clause and close your output stream after use.
- Make sure to catch the relevant exceptions that can be thrown.

## Task 2c

Finally call/invoke your helper methods in the `main()` method of `Actor.java`. Assuming, the `ArrayList` you made earlier comprises 3 actor objects. First:

- Call `writeToFile()` method and pass the `ArrayList` you made as an argument.
- Then call the `readFromFile()` method and pass `Actors.txt` as an argument
- Finally call the `checkHasBeenInterviewed()` method and pass `Actors.txt` as an argument again.

***Hint:*** *As the methods throw an exception remember to wrap in try catch block.*

**Example** of correct output (all methods are implemented):

```
{ name='Ryan Reynolds', age='46', hasBeenInterviewed='false'}
{ name='Leonardo DiCaprio', age='48', hasBeenInterviewed='false'}
{ name='Tom Holland', age='26', hasBeenInterviewed='true'}

{ name='Tom Holland', age='26', hasBeenInterviewed='true'}
```
