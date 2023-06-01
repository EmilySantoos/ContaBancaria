package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "      \t\t********************************************************   \t\t");
			System.out.println("\t\t                                                         \t\t");
			System.out.println(Cores.TEXT_WHITE +"\t\t               BANCO DO BRAZIL COM Z                     \t\t");
			System.out.println("\t\t                                                         \t\t");
			System.out.println(Cores.TEXT_BLUE_BOLD+ "  \t\t*********************************************************\t\t");
			System.out.println(Cores.TEXT_BLUE_BOLD +"  \t\t**                                                     **\t\t");
			System.out.println(Cores.TEXT_PURPLE +" \t\t**            1 - Criar Conta                          **\t\t");
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
