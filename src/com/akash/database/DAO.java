package com.akash.database;

import com.akash.entities.Item;
import com.akash.entities.List;
import com.akash.entities.User;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

    private Connection connection;
    private Statement statement;
    private static DAO instance;

    private DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "root");
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Statement getStatement(){
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DAO getInstance(){
        return new DAO();
    }

    public boolean registerUser(User user){
        String query = "insert into users(username,password) values('"+user.getUsername()+"','"+user.getPassword()+"');";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int loginUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        String query = "select userid,password from users where username='"+username+"';";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            String actualPassword;
            while (resultSet.next()) {
                actualPassword = resultSet.getString(2);
                if (actualPassword.equals(password))
                    return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean addList(List newList){
        int userid = newList.getUserId();
        String listName = newList.getListName();
        String query = "insert into lists(listname,userid) values('" + listName + "','" + userid + "');";
        try {
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<List> getLists(int userid){
        String query = "select listid,listName from lists where userid=" + userid + ";";
        ArrayList<List> lists = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                String listName = resultSet.getString(2);
                int listid = resultSet.getInt(1);
                ArrayList<Item> itemList = getItems(listid);
                List list = new List(listid,userid, listName, itemList);
                lists.add(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public boolean deleteList(int listId){
        String query1 = "delete from lists where listid=" + listId + ";";
        String query2 = "delete from items where listid=" + listId + ";";

        try{
            int resultSet = statement.executeUpdate(query1);
            resultSet = statement.executeUpdate(query2);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean addItem(int listId,String item){
        String query = "insert into items(listid,item) values('" + listId + "','" + item + "');";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private ArrayList<Item> getItems(int listId){
        String query = "select * from items where listid=" + listId + ";";
        ArrayList<Item> items = new ArrayList<>();
        Statement statement = getStatement();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int itemId = resultSet.getInt("itemid");
                String item = resultSet.getString("item");
                items.add(new Item(itemId,item));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public boolean deleteItem(int itemId){
        String query = "delete from items where itemid=" + itemId + ";";

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
