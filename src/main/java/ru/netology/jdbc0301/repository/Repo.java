package ru.netology.jdbc0301.repository;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class Repo {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static String script = read("getProductsByName.sql");

    //МЕТОД ВОЗВРАЩАЮЩИЙ СПИСОК ЗАКАЗОВ
    public List<String> getProductName(String name) {
        return namedParameterJdbcTemplate.queryForList(script, new MapSqlParameterSource("name", name), String.class);
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
