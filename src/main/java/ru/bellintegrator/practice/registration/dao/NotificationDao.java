package ru.bellintegrator.practice.registration.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.registration.model.Notification;

public interface NotificationDao extends JpaRepository<Notification, Long> {

    /**
     * Получить сообщение по адресу
     */
    Notification findByEmailAddress(String address);
}