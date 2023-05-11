package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe principal responsável por controlar o sistema de votação.
 */
public class Principal {
  private static void perguntaSeQuerCadastrar(String pessoa) {
    System.out.println(String.format("Cadastrar pessoa %s?", pessoa));
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
  }

  private static void perguntaProximoPasso() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
  }

  private static void cadastrarPessoaCandidata(
      Scanner scanner, 
      GerenciamentoVotacao gerenciamentoVotacao
  ) {
    perguntaSeQuerCadastrar("candidata");
    short estaCadastrando = scanner.nextShort();

    while (estaCadastrando == 1) {
      System.out.println("Entre com o nome da pessoa candidata:");
      String nomePessoaCandidata = scanner.next();

      System.out.println("Entre com o número da pessoa candidata:");
      int numeroPessoaCandidata = scanner.nextInt();

      gerenciamentoVotacao.cadastrarPessoaCandidata(nomePessoaCandidata, numeroPessoaCandidata);

      perguntaSeQuerCadastrar("candidata");
      estaCadastrando = scanner.nextShort();
    }
  }

  private static void cadastraPessoaEleitora(
      Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao
  ) {
    perguntaSeQuerCadastrar("eleitora");
    short estaCadastrando = scanner.nextShort();

    while (estaCadastrando == 1) {
      System.out.println("Entre com o nome da pessoa eleitora:");
      String nomePessoaEleitora = scanner.next();

      System.out.println("Entre com o cpf da pessoa eleitora:");
      String cpfPessoaEleitora = scanner.next();

      gerenciamentoVotacao.cadastrarPessoaEleitora(nomePessoaEleitora, cpfPessoaEleitora);

      perguntaSeQuerCadastrar("candidata");
      estaCadastrando = scanner.nextShort();
    }
  }

  private static void votar(
      Scanner scanner, 
      GerenciamentoVotacao gerenciamentoVotacao
  ) {
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.next();

    System.out.println("Entre com o número da pessoa candidata:");
    int numeroPessoaCandidata = scanner.nextInt();

    gerenciamentoVotacao.votar(cpf, numeroPessoaCandidata);
  }

  private static void executaProximoPasso(
      Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao
  ) {
    perguntaProximoPasso();
    short proximoPasso = scanner.nextShort();

    while (proximoPasso != 3) {
      if (proximoPasso == 1) {
        votar(scanner, gerenciamentoVotacao);
        perguntaProximoPasso();
        proximoPasso = scanner.nextShort();
      } else if (proximoPasso == 2) {
        gerenciamentoVotacao.mostrarResultado();
        perguntaProximoPasso();
        proximoPasso = scanner.nextShort();
      }
    }

    gerenciamentoVotacao.mostrarResultado();
  }

  /**
   * Método principal que inicia o sistema de votação.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);

    cadastrarPessoaCandidata(scanner, gerenciamentoVotacao);
    cadastraPessoaEleitora(scanner, gerenciamentoVotacao);
    executaProximoPasso(scanner, gerenciamentoVotacao);

    scanner.close();
  }
}
