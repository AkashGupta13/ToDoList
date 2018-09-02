package com.akash.entities;

import java.util.ArrayList;

public class List<I> {
    private int userid;
    private int listId;
    private String listName;

    private ArrayList<Item> itemList;

    public List(String listName){
        this.listName = listName;
    }

    public List(int userid,String listName){
        this.userid = userid;
        this.listName = listName;
    }

    public List(int listId, int userid, String listName, ArrayList<Item> itemList){
        this.userid = userid;
        this.listName = listName;
        this.listId = listId;
        this.itemList = itemList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int id) {
        this.userid = userid;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String toString() {
        return "List{" +
                "userid=" + userid +
                ", listId=" + listId +
                ", listName='" + listName + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
