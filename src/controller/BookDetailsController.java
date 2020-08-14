package controller;

import business.BOFactory;
import business.BOType;
import business.custom.BookBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import util.BookDetailsTM;

import java.util.ArrayList;


public class BookDetailsController {
    public TableView<BookDetailsTM> tblBookDetails;
    public TextField txtSearch;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXTextField txtISBN;
    public JFXTextField txtName;
    public JFXTextField txtAuthor;
    public JFXTextField txtPrice;
    public JFXTextField txtAvailability;
    private ArrayList<BookDetailsTM> bookDetailsTMArrayList = new ArrayList<>();


    private BookBO bookBO = BOFactory.getInstance().getBO(BOType.Book);

    public void initialize() {

        txtISBN.setDisable(true);
        txtName.setDisable(true);
        txtAuthor.setDisable(true);
        txtPrice.setDisable(true);
        txtAvailability.setDisable(true);

        tblBookDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblBookDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("isbn"));
        tblBookDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBookDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBookDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblBookDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("availability"));

        loadAllBooks();



            txtSearch.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    ObservableList bookDetails1 = tblBookDetails.getItems();
                    bookDetails1.clear();
                    for (BookDetailsTM bookDetails : bookDetailsTMArrayList) {
                        if(bookDetails.getId().contains(newValue) ||
                        bookDetails.getName().contains(newValue) ||
                        bookDetails.getIsbn().contains(newValue) ||
                        bookDetails.getAuthor().contains(newValue) ||
                                (bookDetails.getPrice()+"").contains(newValue) ||
                        bookDetails.getAvailability().contains(newValue)){

                            bookDetails1.add(bookDetails);
                        }
                    }
                }
            });

            tblBookDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookDetailsTM>() {
                @Override
                public void changed(ObservableValue<? extends BookDetailsTM> observable, BookDetailsTM oldValue, BookDetailsTM newValue) {
                    if(newValue==null){

                        txtISBN.clear();
                        txtName.clear();
                        txtAuthor.clear();
                        txtPrice.clear();
                        txtAvailability.clear();
                        return;

                    }else {
                        txtISBN.setDisable(false);
                        txtName.setDisable(false);
                        txtAuthor.setDisable(false);
                        txtPrice.setDisable(false);
                        txtAvailability.setDisable(false);

                        txtISBN.setText(newValue.getIsbn());
                        txtName.setText(newValue.getName());
                        txtAuthor.setText(newValue.getAuthor());
                        txtPrice.setText(newValue.getPrice().toString());
                        txtAvailability.setText(newValue.getAvailability());
                    }
                }
            });
    }


    private void loadAllBooks() {
        ObservableList<BookDetailsTM> books = tblBookDetails.getItems();
        books.clear();
        try {
            books = FXCollections.observableArrayList(bookBO.getAllBooks());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblBookDetails.setItems(books);
    }


    public void btnUpdate_OnAction(ActionEvent actionEvent) {
        BookDetailsTM selectedItem = tblBookDetails.getSelectionModel().getSelectedItem();
        if(selectedItem==null){
            new Alert(Alert.AlertType.ERROR,"Please select a book to update", ButtonType.OK).showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to update the book?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult()==ButtonType.YES) {

            boolean result = false;
            try {
                result = bookBO.updateBook(txtISBN.getText(), txtName.getText(), txtAuthor.getText(), Double.parseDouble(txtPrice.getText()), txtAvailability.getText(), selectedItem.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the book", ButtonType.OK).show();
            }
        }

    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        BookDetailsTM selectedItem1 = tblBookDetails.getSelectionModel().getSelectedItem();
        if(selectedItem1==null){
            new Alert(Alert.AlertType.ERROR,"Please select a book to delete", ButtonType.OK).showAndWait();
            return;
        }

        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete the book?", ButtonType.YES, ButtonType.NO);
        alert1.showAndWait();
        if(alert1.getResult()==ButtonType.YES) {

            boolean result = false;
            try {
                result = bookBO.deleteBook(selectedItem1.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Book", ButtonType.OK).show();
            } else {
                tblBookDetails.getItems().remove(selectedItem1);
                tblBookDetails.getSelectionModel().clearSelection();
            }
        }
   }
}
