package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import contacontroller.ContaController;
import java.util.Scanner;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		System.out.println("\nCriar Conta\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Marina da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Joaquim Martins", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos ", 8000f, 15);
		contas.cadastrar(cp2);
		contas.listarTodas();

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
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Digite o Número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo da Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite da Conta (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();

				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				contas.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o número da conta:");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:

				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				if (contas.buscarNaCollection(numero) != null) {

					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();

					tipo = contas.retornaTipo(numero);

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}

				} else
					System.out.println("\nConta não encontrada!");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");

				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");

				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_WHITE + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
