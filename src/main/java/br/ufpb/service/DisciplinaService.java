package br.ufpb.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ufpb.model.Disciplina;

@Service
public class DisciplinaService {
	
	public List<Disciplina> disciplinas;
	
	public DisciplinaService() {
		this.disciplinas = new ArrayList<>();
	}
	
	//retorna todas as disciplinas
	public List<Disciplina> getListaDisciplinas(){
		return this.disciplinas;
	}
	
	//Retorna um JSON que representa a disciplina cujo identificador único é id e código 200.
	//Ou retorna JSON de disciplina nula e código 404 (not found) caso o id passado não tenha sido encontrado.
	
	public Disciplina getDisciplinaID(int id) {
		for(Disciplina d: this.disciplinas) {
			if(d.getId() == id) {
				return d;
			}			
		} 
		return null;
	}
	
	/*Remove a disciplina de identificador id do sistema e retorna a disciplina que foi removida (um JSON) e código 200.
	 *  Ou não retorna JSON e retorna código 404 (para disciplina que não foi encontrada).
	 */
	//Ou posso colocar boolean
	
	public Disciplina deleteDisciplinaId(int id) {
		Disciplina disciplina = null;
		for(Disciplina d: this.disciplinas) {
			if(d.getId() == id) {
				disciplina = d;
			}
		}
		if(disciplina != null) {
			this.disciplinas.remove(disciplina);
			return disciplina;
		}
		return disciplina;
	}
	
	
	public int compareTo(Disciplina d) {
		double nota = 0;
		if(nota > d.getNota()) {
			return -1;
		} if(nota < d.getNota()) {
			return 1;
		}
			return 0;		
		
	}
	
	/*Retorna todas as disciplinas inseridas no sistema ordenadas pela nota (da maior para a menor) e código 200.*/
	
	//public List<Disciplina> listaOrdenadaporNota(){
	//	Collections.sort(disciplinas, new Comparator<Disciplina>());
	//}
	
	
	

}
