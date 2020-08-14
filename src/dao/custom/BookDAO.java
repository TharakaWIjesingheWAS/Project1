package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Book;
import util.BookDetailsTM;

import java.util.List;

public interface BookDAO extends CrudDAO< Book,String> {

    List<Book> findAll() throws Exception;
    boolean saveBook(BookDetailsTM bookDetails) throws Exception;
    boolean deleteBook(String bookID) throws Exception;
    boolean updateBook(Book bookDetails) throws Exception;
    String getLastBookId() throws Exception;


}
