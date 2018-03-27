package ru.bellintegrator.practice.user.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.user.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    /**
     * Получить пользователя по login
     */
    User getUserByLogin(String login);

    /**
     * Удалить пользователя по login
     */
    void deleteByLogin(String login);
}
