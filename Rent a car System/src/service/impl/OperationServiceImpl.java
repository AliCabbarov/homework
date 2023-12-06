package service.impl;

import data.GlobalData;
import enums.ExceptionEnums;
import enums.StatusEnums;
import exception.ApplicationException;
import model.Operations;
import response.Response;
import service.OperationService;

import java.util.ArrayList;

public class OperationServiceImpl implements OperationService {
    @Override
    public Response<?> show() {
        if (GlobalData.operations.isEmpty()) {
            throw new ApplicationException(ExceptionEnums.OPERATIONS_NOT_FOUND_EXCEPTION);
        }
        for (Operations operations : GlobalData.operations) {
            System.out.println(operations.toString());
        }
        return new Response<ArrayList<Operations>>().of(StatusEnums.SUCCESS.getMessage(), 200, GlobalData.operations);
    }
}
