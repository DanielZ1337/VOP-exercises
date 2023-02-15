package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private TextField originalText;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decryptButton;
    @FXML
    private TextField encryptedText;
    @FXML
    private TextField decryptedText;
    @FXML
    private RadioButton atbashRadio;
    @FXML
    private ToggleGroup cryptGroup;
    @FXML
    private RadioButton ceasarRadio;
    @FXML
    private Spinner<Integer> ceasarSpinner;
    @FXML
    private TextField ceasarText;

    private CipherInterface crypter;


    @FXML
    private void cryptHandler(ActionEvent event) {
        Object source = event.getSource();

        if (atbashRadio.isSelected()) {
            crypter = new AtbashCipher();
        } else if (ceasarRadio.isSelected()) {
            int keyValue = ceasarSpinner.isVisible() ? ceasarSpinner.getValue() : Integer.parseInt(ceasarText.getText());
            System.out.println(keyValue);
            crypter = new CeasarCipher(keyValue);
        }

        if (source == encryptButton) {
            encryptedText.setText(crypter.encrypt(originalText.getText()));
        } else if (source == decryptButton) {
            decryptedText.setText(crypter.decrypt(encryptedText.getText()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ceasarSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length/ 2));
    }
}
