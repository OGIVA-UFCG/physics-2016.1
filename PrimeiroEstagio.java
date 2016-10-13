package trabalho;

public class PrimeiroEstagio {
	private String nomeQuestao = "Questao 9:";
	private String enunciado = "Na Fig 22-32 as quatro particulas formam um quadrado de lado a = 5cm\n"
			+ "e tem cargas q1 = +10,0nC, q2 = -20,0nC, q3 = +20,0nC e q4 = -10,0nC.\n"
			+ "Qual eh o campo eletrico no centro do quadrado, em termos de vetores unitarios?";
	private static final double k = 0.899;
	Util util = new Util();

	private double q1;
	private double q2;
	private double q3;
	private double q4;
	private double a;
	
	public void menuQuestao() {
		util.inicioQuestao(nomeQuestao, enunciado);

		restauraValores();
		final int SAIR = 3;
		int opcao = 0;

		do {
			System.out.println("Escolha o que deseja fazer: ");
			System.out.println("1 - Resolver a questao original");
			System.out.println("2 - Alterar valor(es) da questao");
			System.out.println("3 - Voltar");
			System.out.println("");
			
			System.out.print("Digite a opcao: ");
			opcao = util.lerInteiro();

			if (opcao == 1) {
				resolve();
				util.menuQuestao();
				
			} else if (opcao == 2) {
				int outraOpcao = 0;
				do {
					System.out.println("");
					System.out.println("Opcoes:");
					System.out.println("1 - Alterar valor das cargas.");
					System.out.println("2 - Alterar o valor de a (lado do quadrado)");
					System.out.println("3 - Resolver a questao com o(s) novo(s) valor(es).");

					System.out.print("Digite a opcao: ");
					outraOpcao = util.lerInteiro();

					if (outraOpcao == 1) {
						this.q1 = util.alterarValor("carga q1 (+)");
						this.q2 = util.alterarValor("carga q2 (-)");
						this.q3 = util.alterarValor("carga q3 (+)");
						this.q4 = util.alterarValor("carga q4 (-)");
					} else if (outraOpcao == 2) {
						this.a = util.alterarValor("a (lado do quadrado)");
					}

				} while (outraOpcao != 3);
				resolve();
				util.menuQuestao();
			}

		} while (opcao != SAIR);

		util.menuPrincipal();

	}

	private void resolve() {
		double q1 = this.q1;
		double q2 = this.q2;
		double q3 = this.q3;
		double q4 = this.q4;
		double a = this.a;
		
		System.out.println("\nRESOLUCAO:\n");
		System.out.println("Vamos, primeiro, converter os valores fornecidos na questão. Ficaremos então com:\n" + 
					"q1 = " + q1 + "x 10^-9 C, q2 = " + q2 + "x 10^-9 C, q3 = " + q3 +"x 10^-9 C, q4 = " + q4 + "x 10^-9 C, e o lado do quadrado (a) eh " + a + "x10^-2 m");
		double r = (Math.pow(a, 2) / 20);
		System.out.println("Calculando a distancia entre q1 e q3, temos que r = 2a^2, e ficamos entao com r^2 = " + r + "x10^-3 m^2.\n");
		
		double e1 = (k * (q1/r));
		double e2 = (k * (q2/r));
		double e3 = (k * (q3/r));
		double e4 = (k * (q4/r));
		System.out.println("Calculando os valores dos campos gerados pelas cargas ficamos com E1 = " + e1 + "x10^4 N/C, E2 = " + e2 + "x10^4 N/C, " + 
					"E3 = " + e3 + "x10^4 N/C, e E4 = " + e4 + "x10^4 N/C, ");
		double e[] = calculaCampo(e1, e2, e3, e4);
		System.out.printf("Calculando tambem o vetor campo eletrico E, temos que E = (%.2fx10^5 N/C)i, (%.2fx10^5 N/C)j.", e[0], e[1]);
		System.out.println("\n");
	}

	private void restauraValores() {
		this.q1 = +10.0;
		this.q2 = -20.0;
		this.q3 = +20.0;
		this.q4 = -10.0;
		this.a = 5.0;
	}
	
	private double[] calculaCampo(double e1, double e2, double e3, double e4) {
		double[] array = new double[2];
		
		double c1 = 0;
		double c2 = 0;
		
		if (e1 < 0 && e2 > 0 && e3 < 0 && e4 > 0) {
			c1 = Math.sqrt(Math.pow(e3, 2) + Math.pow(e4, 2)) - Math.sqrt(Math.pow(e1, 2) + Math.pow(e2, 2));
			c2 = Math.sqrt(Math.pow(e1, 2) + Math.pow(e4, 2)) - Math.sqrt(Math.pow(e2, 2) + Math.pow(e3, 2));
		}
		
		else if (e1 > 0 && e2 < 0 && e3 > 0 && e4 < 0) {
			c1 = Math.sqrt(Math.pow(e2, 2) + Math.pow(e1, 2)) - Math.sqrt(Math.pow(e3, 2) + Math.pow(e4, 2));
			c2 = Math.sqrt(Math.pow(e2, 2) + Math.pow(e3, 2)) - Math.sqrt(Math.pow(e1, 2) + Math.pow(e4, 2));
		}
		
		array[0] = c1;
		array[1] = c2 / 10.0;
		
		return array;
	}

}