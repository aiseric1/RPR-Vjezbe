package ba.unsa.etf.rpr.lv6_z1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class kalkulatorController {

    @FXML
    public Label display;
    private String generalOperationObject;

    private boolean decimalClick = false;
    private Double firstDouble;

    @FXML
    private void Number(ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        String oldText = display.getText();
        String newText = oldText + digit;
        display.setText(newText);
    }

    @FXML
    private void dot(ActionEvent event) {
        if (decimalClick == false) {
            String digit = ((Button) event.getSource()).getText();
            String oldText = display.getText();
            String newText = oldText + digit;
            display.setText(newText);
        }
    }

    @FXML
    void operation(ActionEvent event) {
        generalOperationObject = ((Button)event.getSource()).getText();
        switch (generalOperationObject){
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                String currentText = display.getText();
                firstDouble = Double.parseDouble(currentText);
                display.setText("");
                decimalClick = false;
                break;
            default:
        }
    }

    @FXML
    void equals(ActionEvent event) {
        double secondDouble;
        double result = 0;
        String secondText = display.getText();
        secondDouble = Double.parseDouble(secondText);
        switch (generalOperationObject){
            case "+":
                result = firstDouble + secondDouble;
                break;
            case "-":
                result = firstDouble - secondDouble;
                break;
            case "X":
                result = firstDouble * secondDouble;
                break;
            case "/":
                result = firstDouble / secondDouble;
                break;
            case "%":
                result = firstDouble % secondDouble;
                break;
            default:
        }
        String format = String.format("%.1f",result);
        display.setText(format);
    }
}


