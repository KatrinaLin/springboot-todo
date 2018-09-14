package com.example.demo;

public class Item {
    private int id = 1;
    private String value = "item";
    private boolean checked = false;

    public Item(int id, String value, boolean checked) {
        this.id = id;
        this.value = value;
        this.checked = checked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
