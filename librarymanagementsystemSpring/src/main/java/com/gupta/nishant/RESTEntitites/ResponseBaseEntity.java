package com.gupta.nishant.RESTEntitites;

public abstract class ResponseBaseEntity {

    private ResponseStatusEnums.ResponseStatus status;
    private String message;
    private Object body;

    public ResponseStatusEnums.ResponseStatus getStatus() {
        return status;
    }

    protected void setStatus(ResponseStatusEnums.ResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    protected void setBody(Object body) {
        this.body = body;
    }

    public abstract void formResponseObject(String message, Object body);
}
