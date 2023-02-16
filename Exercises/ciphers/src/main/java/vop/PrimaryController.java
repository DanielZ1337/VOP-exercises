package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {
    @FXML
    TextField message, encryptedMsg, decryptedMsg;
    @FXML
    RadioButton atbash, caesar;
    @FXML
    Spinner<Integer> caesarSpinner;
    @FXML
    Button encryptButton, decryptButton;
    ToggleGroup toggleGroup = new ToggleGroup();

    public void initialize() {
        caesarSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        0,
                        CipherInterface.ALPHABETH.length - 1,
                        CipherInterface.ALPHABETH.length / 2
                )
        );
        caesar.setToggleGroup(toggleGroup);
        atbash.setToggleGroup(toggleGroup);
    }

    public void encryptMessage(ActionEvent event) {
        if (toggleGroup.getSelectedToggle() == toggleGroup.getToggles().get(1)) {
            String encrypted = new AtbashCipher().encrypt(message.getText());
            encryptedMsg.setText(encrypted);
        } else if (toggleGroup.getSelectedToggle() == toggleGroup.getToggles().get(0)) {
            String encrypted = new CaesarCipher(caesarSpinner.getValue()).encrypt(message.getText());
            encryptedMsg.setText(encrypted);
        }
    }

    public void decryptMessage(ActionEvent event) {
        if (toggleGroup.getSelectedToggle() == toggleGroup.getToggles().get(1)) {
            String decrypted = new AtbashCipher().decrypt(encryptedMsg.getText());
            decryptedMsg.setText(decrypted);
        } else if (toggleGroup.getSelectedToggle() == toggleGroup.getToggles().get(0)) {
            String decrypted = new CaesarCipher(caesarSpinner.getValue()).decrypt(encryptedMsg.getText());
            decryptedMsg.setText(decrypted);
        }
    }
}
