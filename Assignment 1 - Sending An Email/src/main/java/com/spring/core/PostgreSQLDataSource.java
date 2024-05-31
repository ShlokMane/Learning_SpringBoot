package com.spring.core;

import org.springframework.stereotype.Component;

@Component
public class PostgreSQLDataSource implements DataSource {

    public PostgreSQLDataSource() {
        System.out.println("PostgreSQLDataSource");
    }

    @Override
    public String[] getEmail() {
        String[] email = {"This is from PostgreSQLDataSource", "PostgreSQLDataSource Testing Email"};
        return email;
    }
}
