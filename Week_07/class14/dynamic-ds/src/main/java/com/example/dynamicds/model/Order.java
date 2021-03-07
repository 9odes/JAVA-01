package com.example.dynamicds.model;

public class Order {
    private Long id;
    private Long userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserName() {
        return userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "{\"Order\":{"
                + "\"id\":"
                + id
                + ",\"userName\":"
                + userName
                + "}}";

    }
}
