package com.mxi.maintsuite.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ValidationError
 */
public class ValidationError {
  /*  @JsonProperty("message")
    private String message = null;

    @JsonProperty("errors")
    private Errors errors = null;

    public ValidationError message(String message) {
        this.message = message;
        return this;
    }

    *//**
     * Get message
     *
     * @return message
     **//*
    @JsonProperty("message")
    @ApiModelProperty(value = "")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidationError errors(Errors errors) {
        this.errors = errors;
        return this;
    }

    *//**
     * Get errors
     *
     * @return errors
     **//*
    @JsonProperty("errors")
    @ApiModelProperty(value = "")
    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValidationError validationError = (ValidationError) o;
        return Objects.equals(this.message, validationError.message) &&
                Objects.equals(this.errors, validationError.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, errors);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ValidationError {\n");

        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    *//**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     *//*
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }*/
}

