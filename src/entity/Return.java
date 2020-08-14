package entity;

import java.io.Serializable;
import java.sql.Date;

public class Return implements SuperEntity {

    private Date return_Date;
    private int issueID;
    private Double fineFee;

    public Return() {
    }

    public Return(Date return_Date, int issueID, Double fineFee) {
        this.return_Date = return_Date;
        this.issueID = issueID;
        this.fineFee = fineFee;
    }

    public Date getReturn_Date() {
        return return_Date;
    }

    public void setReturn_Date(Date return_Date) {
        this.return_Date = return_Date;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public Double getFineFee() {
        return fineFee;
    }

    public void setFineFee(Double fineFee) {
        this.fineFee = fineFee;
    }

    @Override
    public String toString() {
        return "Return{" +
                "return_Date=" + return_Date +
                ", issueID=" + issueID +
                ", fineFee=" + fineFee +
                '}';
    }
}
