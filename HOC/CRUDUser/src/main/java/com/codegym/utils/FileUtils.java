package com.codegym.utils;

import com.codegym.model.EGender;
import com.codegym.model.ERole;
import com.codegym.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> List<T> readFile(String path, String typeUser) {
        List<T> datas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] items = line.split(",");
                long idUser = Long.parseLong(items[0]);
                String name = items[1];
                String address = items[2];
                EGender eGender = EGender.valueOf(items[3]);
                ERole eRole = ERole.valueOf(items[4]);
                LocalDate date = LocalDate.parse(items[5]);
                User user = new User(idUser,name,address,eGender,eRole,date);
                datas.add((T) user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    public static <T> void writeFile(String path, List<T> datas) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (T p : datas) {
                bufferedWriter.write(p.toString());
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
