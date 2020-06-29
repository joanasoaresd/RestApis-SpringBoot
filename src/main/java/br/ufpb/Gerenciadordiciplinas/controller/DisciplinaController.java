package br.ufpb.Gerenciadordiciplinas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.Gerenciadordiciplinas.Exception.NotFoundException;
import br.ufpb.Gerenciadordiciplinas.model.Disciplina;
import br.ufpb.Gerenciadordiciplinas.service.DisciplinaService;

@RestController
@RequestMapping("/v1/api/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;

	@PostMapping
	public ResponseEntity<Disciplina> postDisciplina(@RequestBody Disciplina disciplina) {
		disciplina.setId(service.getDisciplinas().size() + 1);
		service.createDisciplina(disciplina);
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<?> getDisciplina() {
		return new ResponseEntity<>(service.getDisciplinas(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> getDisciplinaId(@PathVariable Integer id) {
		Disciplina disciplina = this.service.getDisciplinaID(id);
		if (disciplina == null) {
			return new ResponseEntity<Disciplina>(new Disciplina(0, null, 0), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Disciplina>(service.getDisciplinaID(id), HttpStatus.OK);
		}
	}

	@PutMapping("/{id}/nome")
	public ResponseEntity<Disciplina> putNameDisciplina(@PathVariable Integer id, @PathVariable String nome) {
		try {
			return new ResponseEntity<Disciplina>(service.updateNome(id, nome), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}/nota")
	public ResponseEntity<Disciplina> putNota(@PathVariable Integer id, @PathVariable double nota) {
		try {
			return new ResponseEntity<Disciplina>(service.updateNota(id, nota), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Disciplina> deleteDisciplinaId(@PathVariable Integer id) {
		try {
			Disciplina disciplina = service.deleteDisciplinaId(id);
			return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/ranking")
	public ResponseEntity<?> getListOrdered() {
		return new ResponseEntity<>(service.getOrdeneredList(), HttpStatus.OK);
	}

}
