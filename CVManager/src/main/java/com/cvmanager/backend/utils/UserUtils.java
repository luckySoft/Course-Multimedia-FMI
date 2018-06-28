package com.cvmanager.backend.utils;

import com.cvmanager.backend.exceptions.UserNotFoundException;
import com.cvmanager.backend.models.ui.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserUtils {

    public static List<User> getAll() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String usersJson = read();
        return objectMapper.readValue(usersJson, new TypeReference<List<User>>() {});
    }

    private static String read() throws IOException {
        return new String(Files.readAllBytes(ResourceUtils.getFile("classpath:users.json").toPath()));
    }

    private static void write(Path path, String data) throws IOException {
        Files.write(path, data.getBytes());
    }

    public static User addUser(User user) throws IOException {
        List<User> all = UserUtils.getAll();
        Integer id = all.get(all.size() - 1).getId();
        user.setId(++id);
        all.add(user);
        Path path = ResourceUtils.getFile("classpath:users.json").toPath();
        ObjectMapper objectMapper = new ObjectMapper();
        String allJson = objectMapper.writeValueAsString(all);
        write(path, allJson);
        return user;
    }

    public static User updateUser(User user) throws IOException, UserNotFoundException {
        int updateIndex = -1;
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getId().equals(user.getId())) {
                updateIndex = i;
            }
        }
        if (updateIndex == -1) {
            throw new UserNotFoundException("Not Found");
        } else {
            getAll().remove(updateIndex);
            getAll().add(updateIndex, user);
            return user;
        }
    }

    public static User getUser(String id) throws IOException, UserNotFoundException {
        Optional<User> optUser = getAll().stream().filter(user -> id.equals(user.getId().toString())).findFirst();
        return optUser.orElseThrow(() -> new UserNotFoundException("Not Found"));
    }

    public static List<User> findByName(String name) throws IOException {
        List<User> users = getAll().stream()
                .filter(user -> user.getName().contains(name))
                .collect(Collectors.toList());
        return users;
    }
}
