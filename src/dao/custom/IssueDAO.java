package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Issue;
import util.IssueDetailsTM;

import java.util.List;

public interface IssueDAO extends CrudDAO<Issue,String> {

     boolean bookIssue(IssueDetailsTM issueDetails) throws Exception;
     boolean updateIssueDetail(List<IssueDetailsTM> issueDetails) throws Exception;

}
