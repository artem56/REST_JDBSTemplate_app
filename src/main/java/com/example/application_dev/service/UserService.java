package com.example.application_dev.service;

import com.example.application_dev.Entity.UserEntity;
import com.example.application_dev.Exeptions.UserAlreadyExistExeption;
import com.example.application_dev.Exeptions.UserNotExistExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<UserEntity> userRowMapper =  (rs, rowNum) ->
    {
        UserEntity newuser = new UserEntity();
        newuser.setId(rs.getLong("user_id"));
        newuser.setFirstName(rs.getString("first_name"));
        newuser.setLastName(rs.getString("last_name"));
        return newuser;
    };

    public UserEntity registration (UserEntity user) throws UserAlreadyExistExeption
    {

        if ( jdbcTemplate.queryForObject("select exists (select 1 from users where first_name = ? limit 1)", Boolean.class , user.getFirstName()) == Boolean.TRUE)
        {
            throw new UserAlreadyExistExeption("Пользователь с таким именем уже существует");
        }
            jdbcTemplate.update("Insert into users(first_name, last_name) values (?,?)", user.getFirstName(), user.getLastName());
            return user;

    }

    public UserEntity getUser (Long User_id) throws UserNotExistExeption
    {

        if ( jdbcTemplate.queryForObject("select exists (select 1 from users where user_id = ? limit 1)", Boolean.class , User_id ) == Boolean.FALSE)
        {
            throw new UserNotExistExeption("Пользователя с таким Id не существует");
        }
        return jdbcTemplate.queryForObject("Select user_id, first_name, last_name from users where user_id = ?", userRowMapper, User_id);

    }

    public void removeUser (Long User_id) throws  UserNotExistExeption
    {
        if ( jdbcTemplate.queryForObject("select exists (select 1 from users where user_id = ? limit 1)", Boolean.class , User_id ) == Boolean.FALSE)
        {
            throw new UserNotExistExeption("Пользователя с таким Id не существует");
        }
        jdbcTemplate.update("Delete from users where user_id = ?", User_id);

    }

}
