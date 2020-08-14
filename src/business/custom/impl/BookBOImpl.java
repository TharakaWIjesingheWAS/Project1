package business.custom.impl;

import business.custom.BookBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.BookDAO;
import entity.Book;
import util.BookDetailsTM;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {

    private BookDAO bookDAO = DAOFactory.getInstance().getDAO(DAOType.Book);

    public List<BookDetailsTM> getAllBooks() throws Exception{
        List<Book> allBook = bookDAO.findAll();
        List<BookDetailsTM> books = new ArrayList<>();
        for (Book book:allBook){
            books.add(new BookDetailsTM(book.getId(),book.getIsbn(),book.getName(),book.getAuthor(),book.getPrice(),book.getAvailability()));
        }
        return books;
    }

    public boolean saveBook(String id, String isbn, String title, String author, double price, String availability) throws Exception{
        return bookDAO.save(new Book(id,isbn,title,author,price,availability));
    }

    public boolean deleteBook(String bookID) throws Exception{
        return bookDAO.delete(bookID);
    }

    public boolean updateBook(String isbn, String title, String author, double price, String availability,String id) throws Exception{
        return bookDAO.update(new Book(id,isbn,title,author,price,availability));
    }

    public String getNewBookID() throws Exception{
        String lastBookId= bookDAO.getLastBookId();
        if (lastBookId == null){
            return "B001";
        }else {
            int maxId = Integer.parseInt(lastBookId.replace("B",""));
            maxId = maxId+1;
            String id = "";
            if (maxId < 10) {
                id="B00" + maxId;
            } else if (maxId < 100) {
                id = "B0" + maxId;
            } else {
                id = "B" + maxId;
            }
            return id;
        }
    }

}
