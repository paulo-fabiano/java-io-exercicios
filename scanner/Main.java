package scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Exercício: Crie um programa que peça para o usuário inserir dados de três produtos (nome, preço e quantidade). Depois, exiba o total gasto.
 * 
        Usar Scanner para capturar entrada do usuário.
        Calcular o valor total (preço × quantidade).
        Exibir os dados formatados.
 */
// public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Informe o nome do Produto: ");
//        String nome1 = scanner.next();
//
//        System.out.print("Informe o Preço do Produto: R$ ");
//        double preco1 = scanner.nextDouble();
//
//        System.out.print(("Informe a quantidade de produtos: "));
//        int quantidade1 = scanner.nextInt();
//
//        System.out.print("Informe o nome do Produto: ");
//        String nome2 = scanner.next();
//
//        System.out.print("Informe o Preço do Produto: R$ ");
//        double preco2 = scanner.nextDouble();
//
//        System.out.print(("Informe a quantidade de produtos: "));
//        int quantidade2 = scanner.nextInt();
//
//        System.out.print("Informe o nome do Produto: ");
//        String nome3 = scanner.next();
//
//        System.out.print("Informe o Preço do Produto: R$ ");
//        double preco3 = scanner.nextDouble();
//
//        System.out.print(("Informe a quantidade de produtos: "));
//        int quantidade3 = scanner.nextInt();
//
//        System.out.println("----- Lista -----");
//        System.out.println("Nome: "+nome1);
//        System.out.println("Preço: R$ "+preco1);
//        System.out.println("Quantidade: "+quantidade1);
//        System.out.println("Nome: "+nome2);
//        System.out.println("Preço: R$ "+preco2);
//        System.out.println("Quantidade: "+quantidade2);
//        System.out.println("Nome: "+nome3);
//        System.out.println("Preço: R$ "+preco3);
//        System.out.println("Quantidade: "+quantidade3);
//        System.out.println("----- Fim Lista -----");
//
//        double total;
//        total = (preco1 * quantidade1) + (preco2 * quantidade2) + (preco3 * quantidade3);
//        System.out.println("O total é: R$" + total);
//
//    }
//
//};

/*
        Vamos otimizar esse código agora. Depois de ver o que poderia ser otimizado, então resolvi otimizar por conta própria
        Acredito que ficou muito bom!
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Produto> listaProdutos = new ArrayList<>();

        double total = 0;

        for (int i = 1 ; i <= 3 ; i++) {
            Produto produto = new Produto();
            listaProdutos.add(produto.adicionarProduto(scanner, i));
        }

        for (Produto p : listaProdutos) {
            total += (p.preco * p.quantidade);
        }

        System.out.println("----- Lista de Produtos -----");
        int i = 1;
        for (Produto p : listaProdutos) {
            if (i <= 3) {
                System.out.println("Produto " + i);
                System.out.println("Nome: " + p.nome);
                System.out.println("Preço: R$ " + p.preco);
                System.out.println("Quantidade: " + p.quantidade);
                i++;
            }
        }
        System.out.println("----- Fim da Lista -----");
        System.out.println("O total é: R$ "+total);
        /*
            Sempre lembrar de fechar o Scanner para evitar vazamentos de memória, pois o Scanner usa
            recursos do sistema operacional para ler entradas(como teclado). Se não fecharmos o Scanner,
            ele mantém esses recursos abertos.
         */
        scanner.close();

    }

}

class Produto {

    String nome;
    double preco;
    int quantidade;

    public Produto(
            String nome,
            double preco,
            int quantidade)
    {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {}

    public Produto adicionarProduto(Scanner scanner, int i) {
        System.out.println("Produto "+i);
        System.out.print("Informe o nome do produto: ");
        nome = scanner.next();
        System.out.print("Informe o preço do produto: R$ ");
        preco = scanner.nextDouble();
        System.out.print("Informe a quantidade: ");
        quantidade = scanner.nextInt();
        return new Produto(nome, preco, quantidade);
    };

}