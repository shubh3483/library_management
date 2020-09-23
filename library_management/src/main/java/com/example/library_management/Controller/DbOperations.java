package com.example.library_management.Controller;

import com.example.library_management.DataAccessLayer.Book;
import com.example.library_management.DataAccessLayer.Booksissued;
import com.example.library_management.DataAccessLayer.LibraryUsers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbOperations {

    public static Connection connection;

    public static Connection getConnection() throws SQLException {


        if(connection == null) {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubhproj", "root", "abc@123");
        }
        return connection;
    }


    public static void updateInfo(String name,int id) throws SQLException {
        getConnection();

        Statement statement = (Statement)connection.createStatement();
        statement.executeUpdate("update library_users set bookissued = "+name+"where user_id ="+id);
        //PreparedStatement preparedStatement = connection.prepareStatement("update library_users set bookissued = "+name+"where user_id ="+id);
        /*int rows = preparedStatement.executeUpdate();
        if(rows>0){
            System.out.println("updated successfully");
        }else{
            System.out.println("some issue");
        }*/

    }

    public static void updateIssuedBooks(int bookid,String username,String bookname) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into booksissued values("+bookid+",?,?)");


        preparedStatement.setString(1,bookname);
        preparedStatement.setString(2,username);

        int rows = preparedStatement.executeUpdate();

        if(rows>0){
            System.out.println("updated");
        }else {
            System.out.println("some error");
        }
    }

    public static List allIssuedBooks() throws SQLException {

        getConnection();

        List<Booksissued> list = new ArrayList<>();


        String query = "select *from booksissued";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){

            int id = resultSet.getInt(1);
            String bookname = resultSet.getString(2);
            String username = resultSet.getString(3);

            Booksissued bk = new Booksissued(id,bookname,username);
            list.add(bk);
        }
        return list;
    }

}
