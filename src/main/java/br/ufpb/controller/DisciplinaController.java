package br.ufpb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private disciplinaService service;
	
/**
 * POST /v1/api/disciplinas

Adiciona a disciplina no sistema. A própria API deve se encarregar de gerar os identificadores únicos das disciplinas. No corpo da requisição HTTP deve estar um JSON com as informações de nome e nota da disciplina a ser adicionada no sistema.

Retorna a disciplina que foi adicionada (incluindo o id) e código 200.*/
	
	
	

}
