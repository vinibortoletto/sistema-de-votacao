package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  private static void perguntaSeQuerCadastrarCandidato() {
    System.out.println("Cadastrar pessoa candidata?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
  }

  private static void cadastraCandidato(Scanner scanner) {
    perguntaSeQuerCadastrarCandidato();
    short estaCadastrandoCandidato = scanner.nextShort();

    while (estaCadastrandoCandidato == 1) {
      System.out.println("Entre com o nome da pessoa candidata:");
      String nomeDoCandidato = scanner.next();

      System.out.println("Entre com o número da pessoa candidata:");
      String numeroDoCandidato = scanner.next();

      perguntaSeQuerCadastrarCandidato();
      estaCadastrandoCandidato = scanner.nextShort();
    }
  }

  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);

    cadastraCandidato(scanner);

    scanner.close();
  }

}
