package service;

import response.Response;

public interface CarService {
    Response<?> register();
    Response<?> rent();
    Response<?> returnRent();


}
