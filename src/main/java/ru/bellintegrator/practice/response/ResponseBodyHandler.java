package ru.bellintegrator.practice.response;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.practice.response.view.SuccessView;

/**
 * Обработка ответа
 */
@RestControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse response) {
        if (body instanceof RequestProcessingException || body instanceof Exception) {
            LOG.error("response {}");
        } else if (body != null) {
            return "data" + ": " + body;
        }
        return new SuccessView("success");
    }
}

