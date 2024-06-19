package comapny.model.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;


@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalHandler extends DefaultErrorAttributes {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handle(Exception ex,
                                                      WebRequest webRequest) {
        return of(ex, webRequest);
    }


    private Map<String, Object> buildExceptionResponse(String message,
                                                       WebRequest webRequest) {

        Map<String, Object> errorAttributes = getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
        errorAttributes.put("error", message);
        errorAttributes.put("status", HttpStatus.BAD_REQUEST.value());
        errorAttributes.put("timestamp", LocalDateTime.now());
        errorAttributes.put("path", ((ServletRequestAttributes) webRequest).getRequest().getServletPath());

        return errorAttributes;
    }



    private ResponseEntity<Map<String, Object>> of(Exception ex, WebRequest webRequest) {
        return new ResponseEntity<>(
                buildExceptionResponse(ex.getMessage(),
                        webRequest
                ),
                HttpStatus.BAD_REQUEST);
    }

}
