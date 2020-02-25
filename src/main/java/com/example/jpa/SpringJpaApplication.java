package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(SpringJpaApplication.class, args);
        UserService userService = applicationContext.getBean(UserService.class);
        UserEntity user1 = userService.createUser("Vira", "Mazurkevych");
        UserEntity user2 = userService.createUser("Anna", "Scherba");
        UserEntity user3 = userService.createUser("Olga", "Revuka");
        System.out.println("New user created: " + user1);
        System.out.println("New user created: " + user2);
        System.out.println("New user created: " + user3);

        List<UserEntity> allUsers = userService.findAllUsers();
        for (UserEntity user : allUsers) {
            System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName());
        }

        List<UserEntity> foundByLastName = userService.findByLastName("Mazurkevych");
        System.out.println("Found users by last name: ");
        for (UserEntity user : foundByLastName) {
            System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName());
        }

        List<UserEntity> foundByWord = userService.findAllUsersThatHasLetterOrWord("a");
        System.out.println("Found users by word: ");
        for (UserEntity user : foundByWord) {
            System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName());
        }
    }

}
