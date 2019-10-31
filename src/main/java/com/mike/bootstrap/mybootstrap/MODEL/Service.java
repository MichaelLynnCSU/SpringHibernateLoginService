package com.mike.bootstrap.mybootstrap.MODEL;
import com.mike.bootstrap.mybootstrap.MODEL.Topic;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private List<String> foo;
    private boolean bar;

    public Service() {}

    public Service(List<String> foo,  boolean bar) {
        this.foo = foo;
        this.bar = bar;

    }


    public String say() {
        Topic test = new Topic("1", "mike", "read");
        String myObj = test.toString();
        System.out.println(myObj);
        return myObj;

    }

    public int sayUser() {
        return 1;

    }
}
