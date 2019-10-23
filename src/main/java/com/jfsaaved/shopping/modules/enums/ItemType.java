package com.jfsaaved.shopping.modules.enums;

public enum ItemType {

    CD("cd"), BOOK("book"), HOODIE("hoodie"), SOCK("sock"), UNKNOWN("unknown");

    private String value;
    ItemType(String value){ this.value = value; }
    public String getValue() { return value; }

}
