package response;

import java.time.LocalDateTime;

public class Response<T> {
    private  String message;
    private  int status;
    private  LocalDateTime responseTime;
    private  T data;

    public Response(String message, int status, LocalDateTime responseTime, T data) {
        this.message = message;
        this.status = status;
        this.responseTime = responseTime;
        this.data = data;
    }
    public Response(){
    }

    public Response<T> build(String message, int status, LocalDateTime now, T data) {
        return new Response<>(message, status, now, data);
    }
    public Response<T> of(String message,int status, T data){
        return build(message,status,LocalDateTime.now(),data);
    }
    public Response<T> of(String message,int status){
        return build(message,status,LocalDateTime.now(),data);
    }
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getResponseTime() {
        return responseTime;
    }

    public T getData() {
        return data;
    }
}
