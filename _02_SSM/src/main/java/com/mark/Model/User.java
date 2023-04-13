package com.mark.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public String id;
    public String username;
    public String sex;
    public String age;
    public String address;
    public String phonenumber;
}
