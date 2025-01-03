package com.hamitmizrak.innova_springboot.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.Map;

// LOMBOK
@Getter
@Setter
@Builder
@AllArgsConstructor
//@NoArgsConstructor


// Spring Frameworkun Error mekanizması yerine bizim yazdığımız hata yakalama mekanizması
// Jackson: Objeyi => json çevirmek
// Eğer ApiResultta null değer varsa backendten gönderme
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    // sem pvc
    private int status;
    private String error;
    private String message;
    private String path;
    private Map<String,Object> validationErrors;
    private Date createdDate = new Date(System.currentTimeMillis());

    // Constructor (Parametresiz)
    public ApiResult() {
    }

    // Constructor (Parametreli)  pmes
    public ApiResult(String path, String message, String error, int status) {
        this.path = path;
        this.message = message;
        this.error = error;
        this.status = status;
    }

    // Constructor (Parametreli)  pms
    public ApiResult(String path, String message, int status) {
        this.path = path;
        this.message = message;
        this.status = status;
    }


} //end Class ApiResult
