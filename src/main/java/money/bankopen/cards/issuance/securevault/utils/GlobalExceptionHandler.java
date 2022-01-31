package money.bankopen.cards.issuance.securevault.utils;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {

        IssuanceResponse resp = new IssuanceResponse();
        resp.setResponseCode(ResponseCodes.FIELD_ERROR.getCode());
        FieldError f = ex.getBindingResult().getFieldError();
        resp.setException(f.getField() + " " +  ex.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(resp, headers, HttpStatus.BAD_REQUEST);
    }
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("Http not readable :: {}",ex.getMessage());
		Throwable t = ex.getCause();
		IssuanceResponse resp = null;
		if(t instanceof MismatchedInputException) {
			MismatchedInputException mie = (MismatchedInputException) t;
			for(JsonMappingException.Reference ref:mie.getPath()) {
				String expMsg = "Not a valid format for field :: "+"'"+ref.getFieldName()+"'";
				resp = new IssuanceResponse();
				resp.setException(expMsg);
				resp.setResponseCode(ResponseCodes.FIELD_ERROR.getCode());
				return new ResponseEntity<>(resp,headers,HttpStatus.BAD_REQUEST);
			}
		} else {
			resp = new IssuanceResponse();
			resp.setException(ex.getMessage());
			resp.setResponseCode(ResponseCodes.FIELD_ERROR.toString());
		}
		
		return new ResponseEntity<>(resp,headers,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		IssuanceResponse resp = new IssuanceResponse();
		resp.setException(ex.getMessage());
		resp.setResponseCode(ResponseCodes.FIELD_ERROR.getCode());
		log.info("Bad request response:: {}",resp);
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
	}
}