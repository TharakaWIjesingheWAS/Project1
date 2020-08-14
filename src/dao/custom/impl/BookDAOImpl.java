package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BookDAO;
import dbConnection.DBConnection;
import entity.Book;
import util.BookDetailsTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public String getLastBookId() throws Exception {
            ResultSet rst = CrudUtil.execute("SELECT *FROM Book ORDER BY book_id DESC LIMIT 1");
            if (rst.next()){
                return rst.getString(1);
            }else {
                return null;
            }
    }

    @Override
    public List<Book> findAll() throws Exception{
            ResultSet rst = CrudUtil.execute("SELECT * FROM Book");
            List<BookDetailsTM> books = new ArrayList<>();
            while (rst.next()) {
                books.add(new BookDetailsTM(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getDouble(5),
                        rst.getString(6)));
            }
        return null;
    }

    @Override
    public Book find(String key) throws Exception {
        return null;
    }

    @Override
    public boolean save(Book entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Book entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public boolean saveBook(BookDetailsTM bookDetails) throws Exception{
            return CrudUtil.execute("INSERT INTO Book VALUES (?,?,?,?,?,?)",bookDetails.getId(),bookDetails.getIsbn(),bookDetails.getName(),bookDetails.getName(),bookDetails.getAuthor(),bookDetails.getPrice(),bookDetails.getAvailability());
    }


    @Override
    public boolean deleteBook(String bookID) throws Exception{
            return CrudUtil.execute("DELETE FROM Book WHERE ID=?",bookID);
    }

    @Override
    public boolean updateBook(Book bookDetails) throws Exception{
            return CrudUtil.execute("UPDATE Book SET isbn=?,name=?,author=?,price=?, availability=?, WHERE id=?");
    }


}
