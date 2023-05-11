package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe abstrata que representa uma Pessoa.
 */
public abstract class Pessoa {
  public String nome;

  abstract String getNome();

  abstract void setNome(String nome);
}
