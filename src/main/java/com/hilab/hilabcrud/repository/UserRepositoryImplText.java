package com.hilab.hilabcrud.repository;

import com.google.gson.Gson;
import com.hilab.hilabcrud.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.*;

@Component
@Qualifier("fileDB")
public class UserRepositoryImplText implements UserRepository {

    @Value("${database.filename}")
    private String filename;

    private File getFileOrCreateInitial() {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return file;
    }

    private Scanner getScanner() throws Exception {
        return new Scanner(this.getFileOrCreateInitial());
    }

    @Override
    public List<User> findUser(Map<String, String> params) throws Exception {
        List<User> userList = new ArrayList<>();
        String data;
        Gson gson = new Gson();

        Scanner reader = this.getScanner();
        while (reader.hasNextLine()) {
            data = reader.nextLine();
            if (params.isEmpty()) params.put("", "");
            for (String entry : params.values()) {
                if (data.contains(entry)) {
                    User user = gson.fromJson(data, User.class);
                    userList.add(user);
                    break;
                }
            }
        }
        return userList;
    }

    @Override
    public User findByEmail(String email) throws Exception {
        List<User> users = this.findUser(Map.of("email", email));
        if (users.isEmpty()) return null;
        return users.stream().findFirst().get();
    }

    @Override
    public User update(User user) throws Exception {
        StringBuilder buffer = new StringBuilder("");
        Gson gson = new Gson();
        File file = this.getFileOrCreateInitial();
        Scanner reader = this.getScanner();
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            if (data.contains(user.getEmail())) continue;
            buffer.append(data).append(System.lineSeparator());
        }
        FileWriter fw = new FileWriter(file);
        buffer.append(gson.toJson(user));
        fw.write(buffer.toString());
        reader.close();
        fw.close();
        return user;
    }

    @Override
    public User save(User user) throws Exception {
        Gson gson = new Gson();
        File file = this.getFileOrCreateInitial();
        FileWriter fw = new FileWriter(file, true);
        user.setId(UUID.randomUUID().toString());
        fw.write(gson.toJson(user));
        fw.close();
        return user;
    }
}


