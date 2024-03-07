package com.example.tarefas;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotacaoController {
	
	private static final String template = "anotação: %s";
	private final AtomicLong contador = new AtomicLong();
	
	@GetMapping("/anotacao")
	public Anotacao anotacao(
		@RequestParam(value="texto", defaultValue="texto inexistente")
		String texto
	) 
	{
		return new Anotacao(
				contador.incrementAndGet(),
				String.format(template, texto)
			)
		;
	}

}
