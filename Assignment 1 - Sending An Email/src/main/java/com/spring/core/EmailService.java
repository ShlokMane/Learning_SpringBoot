package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EmailService {
    DataSource dataSource;

    @Autowired
    public EmailService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void getEmails() {
        System.out.println(Arrays.toString(dataSource.getEmail()));
    }
}
