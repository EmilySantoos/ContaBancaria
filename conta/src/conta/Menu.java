package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		// Teste da Classe Conta
		Conta c1 = new Conta(1, 123, 1, "Aline", 10000.0f);
		c1.visualizar();
		c1.sacar(15000.0f);
		c1.visualizar();
		c1.depositar(8000.0f);
		c1.visualizar();

		// Teste da Classe Conta
		Conta c2 = new Conta(3, 123, 1, "Marcos", 700000.0f);
		c2.visualizar();
		c2.sacar(12000.0f);
		c2.visualizar();
		c2.depositar(5000.0f);
		c2.visualizar();

		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "Wiliam Martin", 0.0f, 2000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();

		// Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Vitoria dos Santos", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		while (true) {

			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "      \t\t********************************************************   \t\t");
			System.out.println("\t\t                                                         \t\t");
			System.out.println(Cores.TEXT_WHITE + "\t\t               BANCO DO BRAZIL COM Z                     \t\t");
			System.out.println("\t\t                                                         \t\t");
			System.out.println(
					Cores.TEXT_BLUE_BOLD + "  \t\t*********************************************************\t\t");
			System.out.println(
					Cores.TEXT_BLUE_BOLD + "  \t\t**                                                     **\t\t");
			System.out
					.println(Cores.TEXT_PURPLE + " \t\t**            1 - Criar Conta                          **\t\t");
			System.out.println(" \t\t**            2 - Listar todas as Contas               **\t\t");
			System.out.println("\t\t**            3 - Buscar Conta por Numero              **\t\t");
			System.out.println("\t\t**            4 - Atualizar Dados da Conta             **\t\t");
			System.out.println("\t\t**            5 - Apagar Conta                         **\t\t");
			System.out.println("\t\t**            6 - Sacar                                **\t\t");
			System.out.println("\t\t**            7 - Depositar                            **\t\t");
			System.out.println("\t\t**            8 - Transferir valores entre Contas      **\t\t");
			System.out.println("\t\t**            9 - Sair                                 **\t\t");
			System.out.println("\t\t**                                                     **\t\t");
			System.out.println("\t\t*********************************************************\t\t");
			System.out.println(Cores.TEXT_WHITE + "   \t\tEntre com a opção desejada:                          \t\t");
			System.out.println("\t\t                                                     \t\t");

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println("Saque\n\n");

				break;
			case 7:
				System.out.println("Depósito\n\n");

				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

}
