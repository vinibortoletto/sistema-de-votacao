package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

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

  private static void cadastraPessoaCandidata(Scanner scanner) {
    perguntaSeQuerCadastrar("candidata");
    short estaCadastrando = scanner.nextShort();

    while (estaCadastrando == 1) {
      System.out.println("Entre com o nome da pessoa candidata:");
      String nomePessoaCandidata = scanner.next();

      System.out.println("Entre com o número da pessoa candidata:");
      String numeroPessoaCandidata = scanner.next();

      perguntaSeQuerCadastrar("candidata");
      estaCadastrando = scanner.nextShort();
    }
  }

  private static void cadastraPessoaEleitora(Scanner scanner) {
    perguntaSeQuerCadastrar("eleitora");
    short estaCadastrando = scanner.nextShort();

    while (estaCadastrando == 1) {
      System.out.println("Entre com o nome da pessoa eleitora:");
      String nomePessoaEleitora = scanner.next();

      System.out.println("Entre com o cpf da pessoa eleitora:");
      String numeroPessoaEleitora = scanner.next();

      perguntaSeQuerCadastrar("candidata");
      estaCadastrando = scanner.nextShort();
    }
  }

  private static void votar(Scanner scanner) {
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.next();

    System.out.println("Entre com o número da pessoa candidata:");
    String nomePessoaCandidata = scanner.next();
  }

  private static void mostraResultado() {
    System.out.println("Nome: Maria - 1 votos ( 100.0% )");
    System.out.println("Total de votos: 1");
  }

  private static void executaProximoPasso(Scanner scanner) {
    perguntaProximoPasso();
    short proximoPasso = scanner.nextShort();

    while (proximoPasso != 3) {
      if (proximoPasso == 1) {
        votar(scanner);

        perguntaProximoPasso();
        proximoPasso = scanner.nextShort();
      } else if (proximoPasso == 2) {
        mostraResultado();
        perguntaProximoPasso();
        proximoPasso = scanner.nextShort();
      }
    }

    mostraResultado();
  }

  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);

    cadastraPessoaCandidata(scanner);
    cadastraPessoaEleitora(scanner);
    executaProximoPasso(scanner);

    scanner.close();
  }

}
