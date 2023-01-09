package ru.netology.jdbc0301.repository;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class Repo {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //МЕТОД ВОЗВРАЩАЮЩИЙ СПИСОК ЗАКАЗОВ
    public String getProductName(String name) {
        StringBuilder stringBuilder = new StringBuilder();

        //ПОЛУЧАЕМ ТАБЛИЦУ ИЗ mySQL СОГЛАСНО ПЕРЕДАННОМУ SQL СКРИПТУ
        var setSql = namedParameterJdbcTemplate.queryForRowSet(read("getProductsByName.sql"), Map.of("name", name));
        //ИЗ ПОЛУЧЕННО ТАБЛИЦЫ ПОЛУЧАЕМ ВСЕ ТРУБЕМЫЕ ПОЛЯ ПО НАЗВ СТОБЛЦА
        while (setSql.next()) {
            stringBuilder.append(setSql.getString("product_name") + ", ");
        }
        return stringBuilder.toString();
    }


    // МЕТОД ВОЗВРАЩАЮЩИЙ СОДЕРЖДАНИЕ SQL ФАЙЛА ПО ЕГО НАЗВАНИЮ
    public static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
