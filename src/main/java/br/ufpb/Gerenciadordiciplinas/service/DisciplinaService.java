package br.ufpb.Gerenciadordiciplinas.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.ufpb.Gerenciadordiciplinas.Exception.NotFoundException;
import br.ufpb.Gerenciadordiciplinas.model.Disciplina;

@Service
public class DisciplinaService {

	public List<Disciplina> disciplinas;

	public DisciplinaService() {
		this.disciplinas = new ArrayList<>();
	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public Disciplina getDisciplinaID(int id) {
		for (Disciplina d : this.disciplinas) {
			if (d.getId() == id) {
				return d;
			}
		}
		return null;
	}

	public Disciplina deleteDisciplinaId(int id) throws NotFoundException {
		Disciplina disciplina = null;
		for (Disciplina d : this.disciplinas) {
			if (d.getId() == id) {
				disciplina = d;
			}
		}
		if (disciplina != null) {
			this.disciplinas.remove(disciplina);
			return disciplina;
		}
		throw new NotFoundException("ID NOT FOUND");
	}

	public boolean createDisciplina(Disciplina novaDisciplina) {
		return this.disciplinas.add(novaDisciplina);

	}

	public Disciplina updateNome(int id, String nome) throws NotFoundException {
		Disciplina disciplina = getDisciplinaId(id);
		disciplina.setNome(nome);
		deleteDisciplinaId(id);
		this.disciplinas.add(disciplina);
		return this.disciplinas.get(disciplinas.size() - 1);

	}

	public Disciplina getDisciplinaId(int id) throws NotFoundException {
		for (Disciplina d : this.disciplinas) {
			if (d.getId() == id) {
				return d;
			}
		}
		throw new NotFoundException("ID NOT FOUND");
	}

	public Disciplina updateNota(int id, double nota) throws NotFoundException {
		Disciplina disciplina = getDisciplinaId(id);
		disciplina.setNota(nota);
		deleteDisciplinaId(id);
		this.disciplinas.add(disciplina);
		return this.disciplinas.get(disciplinas.size() - 1);

	}

	public int compareTo(Disciplina d) {
		double nota = 0;
		if (nota > d.getNota()) {
			return -1;
		}
		if (nota < d.getNota()) {
			return 1;
		}
		return 0;

	}

	public List<Disciplina> getOrdeneredList() {
		Collections.sort(disciplinas, new Comparator<Disciplina>() {
			@Override
			public int compare(Disciplina d1, Disciplina d2) {
				return Double.compare(d1.getNota(), d2.getNota());
			}
		});

		Collections.reverse(disciplinas);
		return disciplinas;
	}

}
