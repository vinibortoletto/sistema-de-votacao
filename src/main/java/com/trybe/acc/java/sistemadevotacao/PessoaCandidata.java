package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe que representa uma pessoa candidata em um sistema de votação.
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Cria uma nova instância de PessoaCandidata com o nome e número fornecidos.
   *
   * @param nome   O nome da pessoa candidata.
   * @param numero O número da pessoa candidata.
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public void receberVoto() {
    votos += 1;
  }

  @Override
  public String getNome() {
    return nome;
  }
  
  @Override
  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }
}
