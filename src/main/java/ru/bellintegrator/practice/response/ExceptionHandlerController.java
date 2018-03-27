package ru.bellintegrator.practice.response;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.response.view.ExceptionView;

/**
 * Контроллер обработки исключений
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    /**
     * Обработка собственного исключения
     */
    @ExceptionHandler(RequestProcessingException.class)
    public ExceptionView handleException(RequestProcessingException e) {
        LOG.error("response {}", e.getMessage(), e);
        ExceptionView exceptionView = new ExceptionView();
        exceptionView.error = e.getMessage();
        return exceptionView;
    }

    /**
     * Обработка остальных исключений
     */
    @ExceptionHandler(Exception.class)
    public ExceptionView handleOtherException(Exception e) {
        LOG.error("response {}", e.getMessage(), e);
        ExceptionView exceptionView = new ExceptionView();
        exceptionView.error = "Внутренняя ошибка сервера";
        return exceptionView;
    }

}
