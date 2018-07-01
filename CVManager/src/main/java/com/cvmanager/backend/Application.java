package com.cvmanager.backend;

import com.cvmanager.backend.models.ui.User;
import com.cvmanager.backend.services.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static String read(String name) throws IOException {
        return new String(Files.readAllBytes(ResourceUtils.getFile("classpath:" + name).toPath()));
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String usersJson = read("users.json");
        List<User> users = objectMapper.readValue(usersJson, new TypeReference<List<User>>() {
        });

        for (int i = 0; i < users.size(); i++) {
            userService.copy(users.get(i));
        }
    }
}
