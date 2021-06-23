 package mainPackage.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import mainPackage.Main;
import mainPackage.utils.EvaluateString;

import java.io.IOException;
import java.util.ArrayList;

 public class CalculatorController {

    @FXML
    private Label equation;

    @FXML
    private Label result;

    private ArrayList<String> calculation_history = new ArrayList<>();

    public void insertNumber(String number) {
        equation.setText(equation.getText() + number);
    }

    public void insertOperator(String operator) {
        equation.setText(equation.getText() + " " + operator + " ");
    }

    public void clearEquation(){
        equation.setText("");
    }

    public Label getEquation(){
        return equation;
    }

    public Label getResult(){ return result;}

    public void setResult(String result){
        this.result.setText("= " + result);
    }

    public void openHistWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainPackage/resources/history.fxml"));
            Parent root = loader.load();
            Main.getHistoryStage().setScene(new Scene(root));
            HistoryController historyController = loader.getController();
            historyController.initializeCalculations(calculation_history);
            Main.getHistoryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCalculation(String expression, String result){
        this.calculation_history.add(expression+" = "+result);
    }

    public void deleteLast(){
        if(getResult().getText().isEmpty()){
          StringBuilder text = new StringBuilder(getEquation().getText());
          text.deleteCharAt(text.length()-1);
          getEquation().setText(text.toString());
        }
    }

    public void onMouseClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();

        switch (button.getText()) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(button.getText());
                break;
            case "+":
            case "-":
            case "/":
            case "*":
                insertOperator(button.getText());
                break;
            case "CLEAR":
                clearEquation();
                break;
            case "=":
                int result = EvaluateString.evaluate(this.getEquation().getText());
                setResult(String.valueOf(result));
                addCalculation(this.getEquation().getText(),String.valueOf(result));
                break;
            case "ans":
                insertNumber(getResult().getText().substring(2));
                break;
            case "DELETE":
                deleteLast();
                break;
            case "HIST":
                openHistWindow();
                break;
        }
    }
}
