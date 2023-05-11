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
  
}
