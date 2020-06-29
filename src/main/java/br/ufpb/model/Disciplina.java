package br.ufpb.model;

public class Disciplina {
//disciplina é uma classe que tem os seguintes atributos: id:int, nome:String e nota:double.
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
