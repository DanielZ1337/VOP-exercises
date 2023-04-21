package lecture12.examprep.examprep;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import lecture12.examprep.examprep.boilerplate.Facade;
import lecture12.examprep.examprep.boilerplate.LaundryConstants;
import lecture12.examprep.examprep.boilerplate.LaundrySingleton;

import java.util.Arrays;
import java.util.Objects;

public class HelloController {

    public TextField size_textfield, max_textfield, divisor_textfield, laundry_input, laundry_output;
    public Button fillArrayBtn, fillUniqueArrayBtn;
    public TextArea verify_textarea;
    public RadioButton rdbtn_WACH_6, rdbtn_WACH_12, rdbtn_TUMBLE;
    public Label l_wach6, l_wach12, l_dryer;
    private ToggleGroup toggleGroup = new ToggleGroup();

    Facade facade;


    public void initialize() {
        LaundrySingleton.getInstance().buildLaundry();
        toggleGroup.getToggles().add(rdbtn_WACH_6);
        toggleGroup.getToggles().add(rdbtn_WACH_12);
        toggleGroup.getToggles().add(rdbtn_TUMBLE);
        l_wach6.setText(LaundryConstants.WACH_6);
        l_wach12.setText(LaundryConstants.WACH_12);
        l_dryer.setText(LaundryConstants.TUMBLE);
        facade = new Facade();
    }

    public void fillArray(ActionEvent actionEvent) {
        newLine();
        verify_textarea.setText(verify_textarea.getText()
                + Arrays.toString(facade.fillArray(Integer.parseInt(size_textfield.getText()), Integer.parseInt(max_textfield.getText()))));
    }

    public void fillUniqueArray(ActionEvent actionEvent) {
        newLine();
        verify_textarea.setText(verify_textarea.getText()
                + Arrays.toString(facade.fillUniqueArray(Integer.parseInt(size_textfield.getText()), Integer.parseInt(max_textfield.getText()))));
    }

    public void sumOfDivisors(ActionEvent actionEvent) {
        newLine();
        verify_textarea.setText(verify_textarea.getText()
                + "Sum of divisor "
                + divisor_textfield.getText()
                + ":    "
                + facade.sumOfDivisors(Integer.parseInt(divisor_textfield.getText())));
    }

    private void newLine() {
        if (!Objects.equals(verify_textarea.getText(), "")) {
            verify_textarea.setText(verify_textarea.getText() + System.lineSeparator());
        }
    }

    public void calculateLaundromat(KeyEvent keyEvent) {
        try {
            if (toggleGroup.getSelectedToggle() == rdbtn_WACH_6) {
                laundry_output.setText(LaundrySingleton.getInstance().getProgName(0, Integer.parseInt(laundry_input.getText())) + " : " + LaundrySingleton.getInstance().getPrice(0, Integer.parseInt(laundry_input.getText())));
            } else if (toggleGroup.getSelectedToggle() == rdbtn_WACH_12) {
                laundry_output.setText(LaundrySingleton.getInstance().getProgName(1, Integer.parseInt(laundry_input.getText())) + " : " + LaundrySingleton.getInstance().getPrice(1, Integer.parseInt(laundry_input.getText())));
            } else {
                laundry_output.setText(LaundrySingleton.getInstance().getProgName(2, Integer.parseInt(laundry_input.getText())) + " : " + LaundrySingleton.getInstance().getPrice(2, Integer.parseInt(laundry_input.getText())));
            }
        } catch (NumberFormatException e) {
            laundry_output.setText("Please insert a number");
        } catch (NullPointerException e) {
            laundry_output.setText("Program " + laundry_input.getText() + " Doesn't exist!: -1.0");
        }
    }
}