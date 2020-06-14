package com.gupta.nishant.RESTEntitites;

public class SuccessfulResponseEntity extends ResponseBaseEntity{

    public SuccessfulResponseEntity(String message, Object body){
        this.formResponseObject( message,  body);
    }

    @Override
    public void formResponseObject(String message, Object body){
        this.setStatus(ResponseStatusEnums.ResponseStatus.SUCCESSFULL);
        this.setMessage(message);
        this.setBody(body);
    }
}
