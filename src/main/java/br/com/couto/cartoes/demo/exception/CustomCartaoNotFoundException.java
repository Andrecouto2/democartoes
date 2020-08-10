package br.com.couto.cartoes.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cartão not found.")
public class CustomCartaoNotFoundException extends RuntimeException {
}
