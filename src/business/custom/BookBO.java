package business.custom;

import business.SuperBO;
import util.BookDetailsTM;
import util.MemberDetailsTM;

import java.util.List;

public interface BookBO extends SuperBO {

    public List<BookDetailsTM> getAllBooks()throws Exception;

    public boolean saveBook(String id, String isbn, String title, String author, double price, String availability) throws Exception;

    public boolean deleteBook(String bookID) throws Exception;

    public boolean updateBook(String isbn, String title, String author, double price, String availability,String id) throws Exception;

}
