package com.ewiz.sprinbootexcel.model;

import java.util.List;

import javax.validation.Valid;

public class ValidateRequestBodyList<T> {

	@Valid
    private List<T> requestBody;

    public List<T> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(List<T> requestBody) {
        this.requestBody = requestBody;
    }

    public ValidateRequestBodyList(List<T> requestBody) {
        this.requestBody = requestBody;
    }

    public ValidateRequestBodyList() {
    }
}
