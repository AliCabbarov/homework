import java.time.LocalDate;
import java.time.LocalDateTime;

public class Response <T>{
    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setResponseTime(LocalDateTime responseTime) {
        ResponseTime = responseTime;
    }

    public void setData(T data) {
        this.data = data;
    }

    private  String message;
    private  Integer status;
    private  LocalDateTime ResponseTime;
    private  T data;

    public Response( String message, Integer status, T data) {
        this.ResponseTime = LocalDateTime.now();
        this.message = message;
        this.status = status;
        this.data = data;
    }
    public Response(){

    }
    public LocalDateTime getResponseTime() {
        return ResponseTime;
    }

    public String getMessage() {
        return message;
    }



    public Integer getStatus() {
        return status;
    }



    public T getData() {
        return data;
    }


}
