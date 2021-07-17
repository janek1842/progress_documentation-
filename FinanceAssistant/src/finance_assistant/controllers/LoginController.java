package finance_assistant.controllers;
import finance_assistant.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginOnMessage;

    @FXML
    private ImageView leftImage;

    @FXML
    private ImageView lockImage;

    @FXML
    private TextField enterUsernameField;

    @FXML
    private PasswordField enterPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        Image importingImage = new Image("images/calculator-4285211_1280.png");
        leftImage.setImage(importingImage);

        importingImage = new Image("images/61457.png");
        lockImage.setImage(importingImage);
    }

    public void loginButtonAction(ActionEvent event){
        if(enterUsernameField.getText().isBlank()==false && enterPasswordField.getText().isBlank()==false){
            loginOnMessage.setText("Trying to login...");
            validateLogin();
        } else {
            loginOnMessage.setText("Enter username and password please");
        }
    };

    public void registerButtonAction(ActionEvent event){
            createAccountStage();
    };



    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DatabaseConnection connnectionNow = new DatabaseConnection();
        Connection connection = connnectionNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + enterUsernameField.getText() + "' AND password ='" + enterPasswordField.getText() + "'";

        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    loginOnMessage.setText("Congrats!");
                    createAccountStage();
                }else {
                    loginOnMessage.setText("Wrong login!");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void createAccountStage(){
        try{
            Stage registerStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/finance_assistant/resources/register.fxml"));
            registerStage.setTitle("FinanceAssistant register");
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 600, 567));
            registerStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
