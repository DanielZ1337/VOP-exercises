package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML
    private RadioButton ellipseRadio;
    @FXML
    private ToggleGroup ShapeToggle;
    @FXML
    private RadioButton rectangleRadio;
    @FXML
    private RadioButton circleRadio;
    @FXML
    private RadioButton squereRadio;
    @FXML
    private TextField para1;
    @FXML
    private TextField para2;
    @FXML
    private Button infoButton;
    @FXML
    private TextArea resultArea;

    @FXML
    public void initialize() {
        ellipseRadio.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rectangleRadio.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        circleRadio.setUserData(ShapeFacade.SHAPES.CIRCLE);
        squereRadio.setUserData(ShapeFacade.SHAPES.SQUERE);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String result;
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) ShapeToggle.getSelectedToggle().getUserData();
        double p1 = Double.parseDouble(para1.getText());
        if (shape == ShapeFacade.SHAPES.CIRCLE || shape == ShapeFacade.SHAPES.SQUERE) {

            result = ShapeFacade.getInstance().getShapeInfo(shape, p1);
        } else {
            double p2 = Double.parseDouble(para2.getText());
            result = ShapeFacade.getInstance().getShapeInfo(shape, p1, p2);
        }

        resultArea.appendText(result + "\n");

    }

    @FXML
    private void handleRadio(ActionEvent event) {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) ShapeToggle.getSelectedToggle().getUserData();
        para2.setVisible(!(shape == ShapeFacade.SHAPES.CIRCLE || shape == ShapeFacade.SHAPES.SQUERE));
    }
}
