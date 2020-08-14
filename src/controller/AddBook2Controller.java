package controller;

import business.BOFactory;
import business.BOType;
import business.custom.BookBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class AddBook2Controller {
    public JFXButton btnAdd;
    public Label lblBookID;
    public JFXTextField txtBookName;
    public JFXTextField textISBN;
    public JFXTextField TextAuthor;
    public JFXTextField TextPrice;
    public JFXTextField TextAvailability;
    public JFXButton btnSave;


    private BookBO bookBO = BOFactory.getInstance().getBO(BOType.Book);

    public void initialize() {
        txtBookName.setEditable(false);
        textISBN.setEditable(false);
        TextAuthor.setEditable(false);
        TextPrice.setEditable(false);
//        TextAvailability.setEditable(false);
        lblBookID.setText("B_ID");
        btnSave.setDisable(false);
        btnAdd.requestFocus();
    }

    public void btnAdd_OnAction(ActionEvent actionEvent) {
//        lblBookID.setText(bookBO.getNewBookID());
        txtBookName.setEditable(true);
        textISBN.setEditable(true);
        TextAuthor.setEditable(true);
        TextPrice.setEditable(true);
//        TextAvailability.setEditable(true);
        txtBookName.requestFocus();
        btnSave.setDisable(false);

    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        boolean result = false;
        try {
            result = bookBO.saveBook(lblBookID.getText(), textISBN.getText(), txtBookName.getText(), TextAuthor.getText(), Double.parseDouble(TextPrice.getText()), TextAvailability.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!result){
            new Alert(Alert.AlertType.ERROR,"Failed to save the book",ButtonType.OK).show();
        }
    }

}
