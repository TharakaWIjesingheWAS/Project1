package controller;

import business.BOFactory;
import business.BOType;
import business.custom.MemberBO;
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
import util.MemberDetailsTM;

import java.util.ArrayList;
import java.util.List;

public class MemberDetailsController {
    public TextField txtSearch;
    public TableView<MemberDetailsTM> tblMemberDetails;
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    ArrayList<MemberDetailsTM> memberDetailsTMArrayList=new ArrayList<>();

    private MemberBO memberBO = BOFactory.getInstance().getBO(BOType.Member);

    public void initialize(){

        txtNIC.setDisable(true);
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);

        tblMemberDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblMemberDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMemberDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblMemberDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblMemberDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("contact"));

        loadAllMembers();

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tblMemberDetails.getItems().clear();
                for (MemberDetailsTM memberDetails : memberDetailsTMArrayList) {
                    if(memberDetails.getId().contains(newValue) ||
                            memberDetails.getName().contains(newValue) ||
                            memberDetails.getNic().contains(newValue) ||
                            memberDetails.getAddress().contains(newValue) ||
                            memberDetails.getContact().contains(newValue)){

                        tblMemberDetails.getItems().add(memberDetails);
                    }
                }
            }
        });

        tblMemberDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MemberDetailsTM>() {
            @Override
            public void changed(ObservableValue<? extends MemberDetailsTM> observable, MemberDetailsTM oldValue, MemberDetailsTM newValue) {
                if(newValue==null){
                    txtSearch.requestFocus();
                    txtNIC.setDisable(true);
                    txtName.setDisable(true);
                    txtAddress.setDisable(true);
                    txtContact.setDisable(true);

                    txtNIC.clear();
                    txtName.clear();
                    txtAddress.clear();
                    txtContact.clear();

                    return;
                }else{
                    txtName.setText(newValue.getName());
                    txtNIC.setText(newValue.getNic());
                    txtAddress.setText(newValue.getAddress());
                    txtContact.setText(newValue.getContact());

                    txtNIC.setDisable(false);
                    txtName.setDisable(false);
                    txtAddress.setDisable(false);
                    txtContact.setDisable(false);
                }

            }
        });
    }


    public void loadAllMembers(){

        tblMemberDetails.getItems().clear();
        List<MemberDetailsTM>allMembers = null;
        try {
            allMembers = memberBO.getAllMembers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObservableList<MemberDetailsTM> members = FXCollections.observableArrayList(allMembers);
        tblMemberDetails.setItems(members);
    }

    public void btnUpdate_OnAction(ActionEvent actionEvent) {
        MemberDetailsTM selectedItem = tblMemberDetails.getSelectionModel().getSelectedItem();
        if(selectedItem==null){
            new Alert(Alert.AlertType.ERROR,"Please select a member to update", ButtonType.OK).showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to update the selected member", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES){

            boolean result = false;
            try {
                result = memberBO.updateMember(txtNIC.getText(),txtName.getText(),txtAddress.getText(),txtContact.getText(),selectedItem.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR,"Failed to update the member",ButtonType.OK).show();
            }
        }else{
            tblMemberDetails.getSelectionModel().clearSelection();
            txtSearch.clear();

        }
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        MemberDetailsTM selectedItem = tblMemberDetails.getSelectionModel().getSelectedItem();
        if(selectedItem==null){
            new Alert(Alert.AlertType.ERROR,"Please select a member to delete", ButtonType.OK).showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete the selected member", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES){

            boolean result = false;
            try {
                result = memberBO.deleteMember(selectedItem.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR,"Failed to delete the customer",ButtonType.OK).show();
            }else {
                tblMemberDetails.getItems().remove(selectedItem);
                tblMemberDetails.getSelectionModel().clearSelection();
            }

       }


   }
}
