package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {
    @FXML
    RadioButton ellipseRadio, rectangleRadio, circleRadio, squareRadio;
    ToggleGroup toggleGroup = new ToggleGroup();
    @FXML
    TextField t1, t2;
    @FXML
    TextArea textArea;

    @FXML
    public void initialize() {
        ellipseRadio.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rectangleRadio.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        circleRadio.setUserData(ShapeFacade.SHAPES.CIRCLE);
        squareRadio.setUserData(ShapeFacade.SHAPES.SQUARE);
        ellipseRadio.setToggleGroup(toggleGroup);
        rectangleRadio.setToggleGroup(toggleGroup);
        circleRadio.setToggleGroup(toggleGroup);
        squareRadio.setToggleGroup(toggleGroup);
    }

    public void shapeActionHandler(ActionEvent event) {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroup.getSelectedToggle().getUserData();
        switch (shape) {
            case SQUARE, CIRCLE -> {
                enableTwoTextFields(true, false);
            }
            case RECTANGLE, ELLIPSE -> {
                enableTwoTextFields(false, true);
            }
        }
    }

    public void getInfoActionHandler(ActionEvent event) {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroup.getSelectedToggle().getUserData();
        String currentText = textArea.getText();
        switch (shape) {
            case SQUARE, CIRCLE -> {
                String result = ShapeFacade.getInstance().getShapeInfo((ShapeFacade.SHAPES) toggleGroup.getSelectedToggle().getUserData(), Double.parseDouble(t1.getText()));
                textArea.setText(currentText += result);
            }
            case RECTANGLE, ELLIPSE -> {
                String result = ShapeFacade.getInstance().getShapeInfo((ShapeFacade.SHAPES) toggleGroup.getSelectedToggle().getUserData(), Double.parseDouble(t1.getText()), Double.parseDouble(t2.getText()));
                textArea.setText(currentText += result);
            }
        }
    }

    private void enableTwoTextFields(boolean b, boolean b1) {
        t2.setDisable(b);
        t2.setVisible(b1);
    }

}
