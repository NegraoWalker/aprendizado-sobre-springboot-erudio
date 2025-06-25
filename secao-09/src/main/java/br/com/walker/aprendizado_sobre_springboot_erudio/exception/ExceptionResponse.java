package br.com.walker.aprendizado_sobre_springboot_erudio.exception;

import java.io.Serializable;
import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) implements Serializable {
}
