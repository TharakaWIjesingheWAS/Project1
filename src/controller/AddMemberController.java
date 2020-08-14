package controller;

import business.BOFactory;
import business.BOType;
import business.custom.MemberBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class AddMemberController {
    public JFXButton btnAdd;
    public Label lblMemberID;
    public JFXTextField txtMemberName;
    public JFXTextField txtNIC;
    public JFXTextField txtContact;
    public JFXButton btnSave;
    public JFXTextArea txtAddress;

    private MemberBO memberBO = BOFactory.getInstance().getBO(BOType.Member);

    public void initialize(){
        txtMemberName.setEditable(false);
        txtNIC.setEditable(false);
        txtAddress.setEditable(false);
        txtContact.setEditable(false);
        lblMemberID.setText("M_ID");
        btnSave.setDisable(true);
        btnAdd.requestFocus();
    }


    public void btnAdd_OnAction(ActionEvent actionEvent) {

//        lblMemberID.setText(memberBO.getNewMemberID());
        txtMemberName.setEditable(true);
        txtNIC.setEditable(true);
        txtAddress.setEditable(true);
        txtContact.setEditable(true);
        btnSave.setDisable(false);
        txtMemberName.requestFocus();


    }

    public void btnSave_OnAction(ActionEvent actionEvent) {

        try {
            memberBO.saveMember(lblMemberID.getText(),
                    txtNIC.getText(),
                    txtMemberName.getText(),
                    txtAddress.getText(),
                    txtContact.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

