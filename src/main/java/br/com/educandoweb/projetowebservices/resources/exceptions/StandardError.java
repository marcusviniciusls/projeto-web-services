package br.com.educandoweb.projetowebservices.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.Objects;

public class StandardError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(){}

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardError)) return false;
        StandardError that = (StandardError) o;
        return Objects.equals(getTimestamp(), that.getTimestamp()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getError(), that.getError()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getPath(), that.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimestamp(), getStatus(), getError(), getMessage(), getPath());
    }
}
