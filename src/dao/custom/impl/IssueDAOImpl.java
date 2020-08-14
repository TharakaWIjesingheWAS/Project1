package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.IssueDAO;
import dbConnection.DBConnection;
import entity.Issue;
import util.IssueDetailsTM;
import util.MemberDetailsTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IssueDAOImpl implements IssueDAO {

    @Override
    public boolean bookIssue(IssueDetailsTM issueDetails) throws Exception{
            return CrudUtil.execute("INSERT INTO Issue VALUES (?,?,?)",issueDetails.getMember_id(),issueDetails.getBook_id(),issueDetails.getIssue_date());

    }

    @Override
    public boolean updateIssueDetail(List<IssueDetailsTM> issueDetails) throws Exception{
//        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Issue SET detail=? WHERE issue_id=?");
            boolean result = false;
            for (IssueDetailsTM issueDetails1: issueDetails){
                pstm.setObject(1,issueDetails1.getIssue_id());
                result = CrudUtil.execute("UPDATE Issue SET detail=? WHERE issue_id=?") ;
                if (!result){
                    return false;
                }
            }
            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Override
    public List<Issue> findAll() throws Exception {
        return null;
    }

    @Override
    public Issue find(String key) throws Exception {
        return null;
    }

    @Override
    public boolean save(Issue entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Issue entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
