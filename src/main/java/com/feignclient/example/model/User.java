package com.feignclient.example.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private Integer age;
}
