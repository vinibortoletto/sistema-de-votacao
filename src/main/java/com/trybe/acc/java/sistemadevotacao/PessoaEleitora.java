package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe que representa uma pessoa eleitora em um sistema de votação.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  @Override
  String getNome() {
    return nome;
  }

  @Override
  void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
