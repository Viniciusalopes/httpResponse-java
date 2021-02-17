/*
 *  License   : MIT - Copyright 2021 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Author    : Vinicius Lopes
 *  Date      : 17/02/2021 01:03:31 
 *  Project   : HttpResponseJava
 *  Version   : 0.0.1
 *  Purpose   :
 *  Changelog : 2020-01-00 v.0.0.2 (Vinicius Lopes)
 */
package br.com.vovolinux.httpresponsejava;

import org.json.simple.JSONObject;

/**
 *
 * @author vovostudio
 */
public class HttpResponse {

    private int status_code = 0;
    private String type_response = "";
    private String response = "";
    private String request = "";
    private String details = "";
    private JSONObject data = null;

    public HttpResponse() {

    }

    public HttpResponse(int status_code) {
        this.status_code = status_code;
    }

    public HttpResponse(int status_code, String type_response, String response, String request, String details, JSONObject data) {
        this.status_code = status_code;
        this.type_response = type_response;
        this.response = response;
        this.request = request;
        this.details = details;
        this.data = data;
    }

    public int getStatusCode() {
        return status_code;
    }

    public String getTypeResponse() {
        return type_response;
    }

    public String getResponse() {
        return response;
    }

    public String getRequest() {
        return request;
    }

    public String getDetails() {
        return details;
    }

    public JSONObject getData() {
        return data;
    }

    public void setStatusCode(int status_code) {
        this.status_code = status_code;
    }

    public void setTypeResponse(String type_response) {
        this.type_response = type_response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

}
