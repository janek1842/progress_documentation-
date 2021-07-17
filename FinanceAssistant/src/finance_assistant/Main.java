package finance_assistant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/finance_assistant/resources/login.fxml"));
        primaryStage.setTitle("FinanceAssistant");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 632, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
