package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ToolBarController {
    public VBox root;
    public JFXButton btnLogOut;
    @FXML
    private JFXButton btnAddMember;

    @FXML
    private JFXButton btnAddBook;

    @FXML
    private JFXButton btnBookDetails;

    @FXML
    private JFXButton btnMemberDetail;

   

    public void btnAddMember_OnAction(javafx.event.ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/addMember.fxml"));
            Scene mainScene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(mainScene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddBook_OnAction(javafx.event.ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/addBook2.fxml"));
            Scene mainScene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(mainScene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnBookDetails_OnAction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/bookDetails.fxml"));
            Scene mainScene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(mainScene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnMemberDetail_OnAction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/memberDetails.fxml"));
            Scene mainScene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(mainScene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnLogout_OnAction(ActionEvent actionEvent) {
        System.exit(0);
//        try {
//            Parent root = FXMLLoader.load(this.getClass().getResource("/view/login2.fxml"));
//            Scene mainScene = new Scene(root);
//            Stage stage = (Stage)(this.root.getScene().getWindow());
//            stage.setScene(mainScene);
//            stage.centerOnScreen();
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
