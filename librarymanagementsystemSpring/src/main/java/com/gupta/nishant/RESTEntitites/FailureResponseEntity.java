package com.gupta.nishant.RESTEntitites;

public class FailureResponseEntity extends ResponseBaseEntity {

    public FailureResponseEntity(String message, Object body) {
        this.formResponseObject(message, body);
    }

    @Override
    public void formResponseObject(String message, Object body) {
        this.setStatus(ResponseStatusEnums.ResponseStatus.FAILED);
        this.setMessage(message);
        this.setBody(body);
    }
}
