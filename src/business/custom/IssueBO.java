package business.custom;

import business.SuperBO;

import java.time.LocalDate;

public interface IssueBO extends SuperBO {

    public boolean bookIssue(String id, String id1, LocalDate date) throws Exception;
}
