package serializacao;

/*
Exercício 1: Serialização e Desserialização de um Objeto

Objetivo: Criar um programa que salva um objeto em um arquivo e depois o lê de volta.

ObjectOutputStream e ObjectInputStream para salvar e recuperar objetos.
Serializable para permitir que um objeto seja salvo.

       Tarefa:
        Crie uma classe Pessoa com os atributos nome e idade.
        Peça para o usuário digitar um nome e uma idade.
        Salve esse objeto em um arquivo chamado "pessoa.dat".
        Depois, recupere o objeto do arquivo e exiba os dados no console.
 */

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*
            Podemos chamar o método já na inicialização do Objeto, poŕem precsamos definir o método como static

            Podemos também fazer do jeito que eu já estava fazendo, que é passar um contrutor vazio e depois chamando o método.
         */
        Pessoa pessoa = Pessoa.adicionarPessoa(scanner);

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("pessoa.dat");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                FileInputStream fileInputStream = new FileInputStream("pessoa.dat");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)

        ){
            objectOutputStream.writeObject(pessoa);
            System.out.println("[INFO] Objeto salvo com sucesso.");

            Pessoa pessoaD = (Pessoa) objectInputStream.readObject();
            System.out.println("[INFO] Objeto lido com sucesso do arquivo.");
            System.out.print("Nome: "+pessoaD.nome+", idade: "+pessoaD.idade);

        }
        catch (Exception e) {
            System.out.print("[ERRO]");
            e.printStackTrace();
        }

        scanner.close();

    }

}

class Pessoa implements Serializable {

    static long serialVersionUID = 1L;
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public static Pessoa adicionarPessoa(Scanner scanner) {
        System.out.print("Informe o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Informe a idade da pessoa: ");
        int idade = scanner.nextInt();
        return new Pessoa(nome, idade);
    }

}