package br.com.objective.exception.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.objective.dto.error.ErrorResponseDto;
import br.com.objective.exception.BadRequestException;


@RestControllerAdvice
public class ResourcesHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponseDto> badRequestException(BadRequestException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				ErrorResponseDto.builder().
				msg(ex.getMessage())
				.httpStatus(HttpStatus.BAD_REQUEST)
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.build());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		Map<String, String> messages = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String field = ((FieldError) error).getField();
			String defaultMessage = error.getDefaultMessage();
			messages.put(field, defaultMessage);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
				.msg(Arrays.toString(messages.entrySet().toArray()))
				.httpStatus(HttpStatus.BAD_REQUEST)
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.build());
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<ErrorResponseDto> unexpectedTypeException(UnexpectedTypeException ex) {
		
		Map<String, String> messages = new HashMap<>();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
				.msg(ex.getMessage())
				.httpStatus(HttpStatus.BAD_REQUEST)
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.build());
	}

}
