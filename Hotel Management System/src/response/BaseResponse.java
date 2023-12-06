package response;

import java.time.LocalDateTime;

public class BaseResponse<T> {
    private int status;
    private String message;
    private LocalDateTime ResponseTime;
    private T data;

    private BaseResponse(int status, String message, LocalDateTime ResponseTime, T data){
    }
    public BaseResponse(){
    }
    private BaseResponse<T> build(int status,String message ,LocalDateTime now, T data){
        return new BaseResponse<>(status,message,now,data);
    }

    public BaseResponse<T> of(int status,String message,T data){
        return build(status,message,LocalDateTime.now(),data);
    }
    public BaseResponse<T> of(int status,String message){
        return build(status,message,LocalDateTime.now(),null);
    }

}
