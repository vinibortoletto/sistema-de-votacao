package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe responsável pelo gerenciamento do sistema de votação.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos;

  /**
   * Cadastra uma pessoa candidata.
   *
   * @param nome   Nome da pessoa candidata.
   * @param numero Número da pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    boolean pessoaCandidataExiste = pessoasCandidatas.contains(pessoaCandidata);

    if (pessoaCandidataExiste) {
      System.out.println("Número pessoa candidata já utilizado!");
      return;
    }

    pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * Cadastra uma pessoa eleitora.
   *
   * @param nome Nome da pessoa eleitora.
   * @param cpf  CPF da pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    boolean pessoaEleitoraExiste = pessoasEleitoras.contains(pessoaEleitora);

    if (pessoaEleitoraExiste) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    pessoasEleitoras.add(pessoaEleitora);
  }

  /**
   * Realiza o voto de uma pessoa eleitora em uma pessoa candidata.
   *
   * @param cpfPessoaEleitora     CPF da pessoa eleitora.
   * @param numeroPessoaCandidata Número da pessoa candidata.
   */
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

  /**
   * Mostra o resultado parcial da votação, exibindo o nome e o número
   * de votos de cada pessoa candidata,
   * bem como a porcentagem de votos que cada pessoa candidata obteve em 
   * relação ao total de votos.
   */
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
