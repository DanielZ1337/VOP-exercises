package JUnitTestSuite;

import binary_search.IterativeBinSearchTest;
import binary_search.RecursiveBinSearchTest;
import employee_details.EmployeeTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({EmployeeTest.class, IterativeBinSearchTest.class, RecursiveBinSearchTest.class})

public class TestSuite {

}
