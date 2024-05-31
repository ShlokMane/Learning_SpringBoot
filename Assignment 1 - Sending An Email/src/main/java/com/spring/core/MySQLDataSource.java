package com.spring.core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySQLDataSource implements DataSource{

    public MySQLDataSource() {
        System.out.println("MySQLDataSource");
    }
    @Override
    public String[] getEmail() {
        String[] email = {"This is from MySQLDataSource", "MySQLDataSource Testing Email"};
        return email;
    }
}
