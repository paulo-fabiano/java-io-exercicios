package io;

/*
    Exercício: Escreva um programa que solicite ao usuário uma lista de nomes e armazene em um arquivo nomes.txt.
    Em seguida, leia o arquivo e exiba os nomes.

    Requisitos:
       - Usar FileWriter para gravar os nomes.
       - Usar BufferedReader para ler o arquivo e exibir os dados.
 */

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String linhaLeitura;
        Scanner scanner = new Scanner(System.in);

        // Escrevendo os nomes no arquivo
        try {
            FileWriter fileWriter = new FileWriter("nomes.txt", true);
            for (int i = 1 ; i <= 5 ; i++) {
                System.out.print("Informe o "+i+"º nome: ");
                fileWriter.write(scanner.nextLine() + "\n");
            }
            /*
                Lembrar de fechar o arquivo após gravar os nomes, pois pode ocorrer dele não inserir os dados corretamente
             */
            fileWriter.close();
            System.out.println("----- Nomes inseridos -----");
        } catch (IOException e) {
            System.out.print("[ERRO] Erro ao escrever nome no arquivo.");
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("nomes.txt"));
            while((linhaLeitura = reader.readLine()) != null) {
                System.out.println(linhaLeitura+"\n");
            }
        } catch (IOException e) {
            System.out.print("[ERRO] Não foi possível ler o arquivo");
            e.printStackTrace();
        }

        /*
            Lembrar também de sempre fechar o Scanner!
         */
        scanner.close();
    }

}