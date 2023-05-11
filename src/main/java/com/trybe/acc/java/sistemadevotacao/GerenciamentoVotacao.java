package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.Arrays;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfComputado;
  private int totalVotos;

  public GerenciamentoVotacao(
      ArrayList<PessoaCandidata> pessoasCandidatas,
      ArrayList<PessoaEleitora> pessoasEleitoras, 
      ArrayList<String> cpfComputado,
      int totalVotos
  ) {
    this.pessoasCandidatas = pessoasCandidatas;
    this.pessoasEleitoras = pessoasEleitoras;
    this.cpfComputado = cpfComputado;
    this.totalVotos = totalVotos;
  }

  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    boolean pessoaCandidataExiste = pessoasCandidatas.contains(pessoaCandidata);

    if (pessoaCandidataExiste) {
      System.out.println("Número pessoa candidata já utilizado!");
      return;
    }

    pessoasCandidatas.add(pessoaCandidata);
  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    boolean pessoaEleitoraExiste = pessoasEleitoras.contains(pessoaEleitora);

    if (pessoaEleitoraExiste) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    pessoasEleitoras.add(pessoaEleitora);
  }

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean cpfExiste = cpfComputado.contains(cpfPessoaEleitora);

    if (cpfExiste) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (numeroPessoaCandidata == pessoaCandidata.getNumero()) {
        pessoaCandidata.receberVoto();
      }
    }

    cpfComputado.add(cpfPessoaEleitora);
  }

 
}
