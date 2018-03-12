package ru.bellintegrator.practice.error;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RequestProcessingException.class)
    public @ResponseBody
    String handleException(RequestProcessingException e) {
        LOG.error("error: " + e.getMessage(), e);
        return "error: " + e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody
    String handleOtherException(Exception e) {
        LOG.error("error: " + e.getMessage(), e);
        return "error: " + "Внутренняя ошибка сервера";
    }
}
