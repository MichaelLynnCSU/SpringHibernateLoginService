package com.mike.bootstrap.mybootstrap.REST;
import com.google.gson.Gson;
import com.mike.bootstrap.mybootstrap.MODEL.PersonDTO;
import com.mike.bootstrap.mybootstrap.MODEL.Service;
import com.mike.bootstrap.mybootstrap.MODEL.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {



        // service beans injected using the @Autowired annotation,
        // this allows them to be used in this controller.

        @Autowired
        private Service topService;


    // get is default method
    @RequestMapping("/")
    public String sayHi(){
        topService.say();
        return "hi";
    }

   //  get is default method
    @RequestMapping("/hello2")
    public String sayHi2(){
        return topService.say();
    }

    //  get is default method
    @RequestMapping("/getList")
    public String sayHi3()
    {
        topService.say();
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        Gson gson = new Gson();
        String test = gson.toJson(messages);
        return test;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody PersonDTO person)
    {
        // Creating the config instance & passing the hibernate config file.
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        // Session object to start the db transaction.
        Session s = config.buildSessionFactory().openSession();
        // Transaction object to begin the db transaction.
        Transaction t = s.beginTransaction();

        // Query - To fetch all employees.
        TypedQuery query =  s.getNamedQuery("User");
        query.setParameter("UserName",person.getFirstName());
        List<User> list = query.getResultList();
        if(list.isEmpty()){
            System.out.println("no user");
            return "no user";
        }
        else {
            for (User emp : list) {
                System.out.println(emp.firstName + "here");
                System.out.println(emp.lastName + "here");
                System.out.println(emp.email + "here");
            }
        }
        String test = person.getFirstName();
        return test;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String adduser(@RequestBody PersonDTO person)
    {
        // Creating the config instance & passing the hibernate config file.
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        // Session object to start the db transaction.
        Session s = config.buildSessionFactory().openSession();
        // Transaction object to begin the db transaction.
        Transaction t = s.beginTransaction();

        // Query - To fetch all employees.
        TypedQuery query =  s.getNamedQuery("User");
        query.setParameter("UserName",person.getFirstName());
        List<User> list = query.getResultList();
        if(list.isEmpty()){
            System.out.println("adding user");
            User u1  = new User(person.getFirstName(), person.getSecondName(), "email16");
            // Saving the employee object to the db.
            s.save(u1);
            s.persist(u1);

            // Committing the transaction in the db.
            t.commit();


        }
        else {
            return "user already esists";
        }
        String test = person.getFirstName();
        return test;
    }

}
