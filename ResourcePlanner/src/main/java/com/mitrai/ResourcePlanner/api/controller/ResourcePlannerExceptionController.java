package com.mitrai.ResourcePlanner.api.controller;

import com.mitrai.ResourcePlanner.api.dto.ExceptionDTO;
import com.mitrai.ResourcePlanner.exception.ResourceNotFoundException;
import com.mitrai.ResourcePlanner.exception.ResourcePlannerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ResourcePlannerExceptionController {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> exception(ResourceNotFoundException ex) {
            return new ResponseEntity<>(new ExceptionDTO(ex.getErrorMsg()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ResourcePlannerException.class)
    public ResponseEntity<ExceptionDTO> exception(ResourcePlannerException ex) {
            return new ResponseEntity<>(new ExceptionDTO(ex.getErrorMsg()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> arithmeticException(ArithmeticException ex) {

        return new ResponseEntity<>(new ExceptionDTO(ex.getLocalizedMessage(), 15), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDTO> handleConstraintViolationException(ConstraintViolationException e) {
        // your code here to handle the exceptions accordingly
        return new ResponseEntity<>(new ExceptionDTO("cons viol", 20), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // your code here to handle the exceptions accordingly
        return new ResponseEntity<>(new ExceptionDTO("arg wrong", 30), HttpStatus.BAD_REQUEST);
    }

}
