package business.custom.impl;

import business.custom.ReturnBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.ReturnDAO;
import util.ReturnBookTM;

public class ReturnBOImpl implements ReturnBO {

    private ReturnDAO returnDAO = DAOFactory.getInstance().getDAO(DAOType.Return);

    public boolean returnBook(ReturnBookTM returnBook) throws Exception{
        return returnDAO.returnBook(returnBook);
    }
}
