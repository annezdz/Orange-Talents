package com.example.api.cars.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {


    private final MessageSource messageSource;

    public CustomRestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request){
        List<String> errors = new ArrayList<>();


        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.add(error.getField() + " : " + error.getDefaultMessage());
        }
        for(ObjectError error : ex.getBindingResult().getGlobalErrors()){
            errors.add(error.getObjectName() + " : " + error.getDefaultMessage());
        }

            ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);

    }



//    private ValidationErrorsOutputDto getValidationErrorsOutputDto(List<ObjectError> objectErrors,
//                                                                   List<FieldError> fieldErrors){
//        ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
//    }

//    private String getErrorMessage(ObjectError error){
//        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
//    }

//    private ValidationErrorsOutputDto buildValidationErrors(List<ObjectError> objectErrors,
//                                                            List<FieldError> fieldErrors){
//        return getValidationErrorsOutputDto(objectErrors, fieldErrors);
//    }

}
