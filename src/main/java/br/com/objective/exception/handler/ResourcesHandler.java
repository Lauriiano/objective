package br.com.objective.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
