package br.ufpb.Gerenciadordiciplinas.model;

public class Disciplina {

	private int id;
	private String nome;
	private double nota;

	public Disciplina(int id, String nome, double nota) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getNota() {
		return nota;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

}
