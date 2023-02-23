package employee_details;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    Employee employee;
    Employee employee1;

    @BeforeEach
    void setUp() {
        employee = new Employee("John", 8000, 25);
        employee1 = new Employee("Mikkel", 12000, 25);
    }

    @DisplayName("Testing appraisal...")
    @Test
    void testCalculateAppraisal() {
        assertEquals(500, (new EmployeeBusinessLogic().calculateAppraisal(employee)));
        assertEquals(1000, (new EmployeeBusinessLogic().calculateAppraisal(employee1)));
    }

    @DisplayName("Testing yearly salary...")
    @Test
    void testCalculateYearlySalary() {
        assertEquals(96000, (new EmployeeBusinessLogic().calculateYearlySalary(employee)));
        assertEquals(144000, (new EmployeeBusinessLogic().calculateYearlySalary(employee1)));
    }

}
