package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos;

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

  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (int i = 0; i < pessoasCandidatas.size(); i++) {
      System.out.println(
          String.format(
            "Nome: %s - %d votos ( %d )", 
            pessoasCandidatas.get(i).getNome(),
            pessoasCandidatas.get(i).getVotos(), 
            calcularPorcentagemVotos(i)
          )
      );
    }

    System.out.println(String.format("Total de votos: %d", totalVotos));
  }

  private double calcularPorcentagemVotos(int indice) {
    PessoaCandidata pessoaCandidata = pessoasCandidatas.get(indice);
    double porcentagemDeVotos = Math.round(pessoaCandidata.getVotos() / totalVotos);
    return porcentagemDeVotos;
  }
}
