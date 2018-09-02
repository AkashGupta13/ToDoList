package com.akash.entities;

public class Item {
    private int itemId;
    private String item;

    Item(String item){
        this.item = item;
    }

    public Item(int itemId, String item){
        this.itemId = itemId;
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", item='" + item + '\'' +
                '}';
    }
}
