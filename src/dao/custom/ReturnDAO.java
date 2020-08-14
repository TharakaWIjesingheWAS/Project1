package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Return;
import util.ReturnBookTM;

public interface ReturnDAO extends CrudDAO<Return,String> {

    public boolean returnBook(ReturnBookTM returnBook) throws Exception;

}
