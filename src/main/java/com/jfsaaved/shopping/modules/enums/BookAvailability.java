package com.jfsaaved.shopping.modules.enums;

public enum BookAvailability {

    PAPERBACK("Paperback"), ELECTRONIC("Electronic");

    private String name;
    BookAvailability(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
