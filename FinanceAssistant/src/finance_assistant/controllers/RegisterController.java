package finance_assistant.controllers;

import finance_assistant.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private ImageView personImageView;

    @FXML
    private Button closeButton;

    @FXML
    private Label registrationEffect;

    @FXML
    private Label registrationEffect1;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField usernameField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image importingImage = new Image("images/edit-user-male.png");
        personImageView.setImage(importingImage);
    }

    public void closeButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void registerButtonAction(ActionEvent event) {
        if (passwordField.getText().equals(confirmField.getText())) {
            registerUser();
            registrationEffect1.setText("Correct password");
            registrationEffect.setText("User registered !");
        } else {
            registrationEffect1.setText("Password does not match");
        }
    }

    public void registerUser() {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connection1 = connection.getConnection();

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        String insertFields = "INSERT INTO user_account (lastname, firstname, username, password) VALUES('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connection1.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationEffect.setText("User has been registered succesfully");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }


}
