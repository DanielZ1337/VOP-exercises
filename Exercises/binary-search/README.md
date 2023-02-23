# Instructor Hours:

You are handed over a Java project, comprising of 2 packages, `employee_details` & `binary_search`

## Task a

Package `employee_details` contains 2 classes, i.e., Employee and EmployeeBusinessLogic.

- Create a Test Class, `EmployeeTest` (should be placed in test->java->employee_details package)
- Write JUnit tests for the following methods in the test class:
    - `testCalculateAppraisal()`  // Test to check appraisal
    - `testCalculateYearlySalary()`   // Test to check yearly salary
- Use this Employee as test input:  
  Employee employee=new Employee(“John”, 8000, 25);

## Task b

Package `binary_search` contains 2 classes for BinarySearch in both a recursive- and an iterative- version.

- Create 2 Test Classes, one for IterativeBinSearch `IterativeBinSearchTest` and the other for
  RecursiveBinSearch `RecursiveBinSearchTest` (should be placed in test->java->binary_search package)
- Write JUnit tests for the following methods in both test classes:
    - `shouldFindIndexOfNumber()` // Find present number
    - `shouldReturnNegativeInsertionPointWhenNotFound()` // Find not-present number
- Use this Array as test input:  
  private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

## Task c

Create a package `JUnitTestSuite` under test->java, and create a class `TestSuite`, to run all the test methods in all
the test classes placed in the `employee_details` and `binary_search` packages

***Hint:*** Add the required annotations to run the Test Suite
