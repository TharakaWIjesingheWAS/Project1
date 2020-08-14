package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ReturnDAO;
import dbConnection.DBConnection;
import entity.Return;
import util.MemberDetailsTM;
import util.ReturnBookTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReturnDAOImpl implements ReturnDAO {

    @Override
    public boolean returnBook(ReturnBookTM returnBook) throws Exception {
            return CrudUtil.execute("INSERT INTO Return VALUES (?,?,?)",returnBook.getReturnDate(),returnBook.getIssueID(),returnBook.getFineFee());
    }

    @Override
    public List<Return> findAll() throws Exception {
        return null;
    }

    @Override
    public Return find(String key) throws Exception {
        return null;
    }

    @Override
    public boolean save(Return entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Return entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }
}
