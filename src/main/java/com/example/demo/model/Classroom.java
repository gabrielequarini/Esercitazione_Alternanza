package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classroom {
	@Id
	private int id;
	private int sezione;
	private String nome;

	public Classroom() {

	}

	public Classroom(int id, int sezione, String nome) {
		super();
		this.id = id;
		this.sezione = sezione;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSezione() {
		return sezione;
	}

	public void setSezione(int sezione) {
		this.sezione = sezione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
