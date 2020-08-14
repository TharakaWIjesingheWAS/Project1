package dao;

import dao.custom.BookDAO;
import dao.custom.IssueDAO;
import dao.custom.MemberDAO;
import dao.custom.ReturnDAO;
import dao.custom.impl.BookDAOImpl;
import dao.custom.impl.IssueDAOImpl;
import dao.custom.impl.MemberDAOImpl;
import dao.custom.impl.ReturnDAOImpl;
import entity.Return;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance(){

        return (daoFactory == null) ?  new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case Book:
                return (T) new BookDAOImpl();
            case Issue:
                return (T) new IssueDAOImpl();
            case Member:
                return (T) new MemberDAOImpl();
            case Return:
                return (T) new ReturnDAOImpl();
            default:
                return null;
        }
    }
//    public BookDAO getBookDAO(){
//        return new BookDAOImpl();
//    }
//
//    public IssueDAO getIssueDAO(){
//        return new IssueDAOImpl();
//    }
//
//    public MemberDAO getMemberDAO(){
//        return new MemberDAOImpl();
//    }
//
//    public ReturnDAO getReturnDAO() {
//        return new ReturnDAOImpl();
//    }
}
