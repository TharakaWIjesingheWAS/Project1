package business.custom.impl;

import business.custom.IssueBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.IssueDAO;
import util.IssueDetailsTM;

import java.time.LocalDate;

public class IssueBOImpl implements IssueBO {

    private IssueDAO issueDAO = DAOFactory.getInstance().getDAO(DAOType.Issue);

    public boolean bookIssue(String id, String id1, LocalDate date) throws Exception{
        return issueDAO.bookIssue(new IssueDetailsTM(id,id1,date));
    }
}
