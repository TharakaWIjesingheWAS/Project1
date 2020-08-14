package business.custom;

import business.SuperBO;
import util.ReturnBookTM;

public interface ReturnBO extends SuperBO {

    public boolean returnBook(ReturnBookTM returnBook) throws Exception;
}
