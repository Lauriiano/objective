package br.com.objective.dto.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {

	private String msg;
	private HttpStatus httpStatus;
	private Integer statusCode;
	
}
