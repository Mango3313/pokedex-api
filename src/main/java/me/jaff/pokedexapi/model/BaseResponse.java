package me.jaff.pokedexapi.model;

public class BaseResponse {
    private Integer status;
    private String message;
    private String source;
    private Object data;

    public BaseResponse(){

    }
    public BaseResponse(Integer status, String message, String source, Object data){
        this.status = status;
        this.message = message;
        this.source = source;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
