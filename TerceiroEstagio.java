package trabalho;

public class TerceiroEstagio {
	String FIM_DE_LINHA = System.lineSeparator();
	private String nomeQuestao = "Questao 1 do Capitulo 29:";
	private String enunciado = "Em um certo local das Filipinas o campo magnetico da Terra tem um " + FIM_DE_LINHA
				+ "modulo de 39 x 10^-6 T, eh horizontal e aponta exatamente para o norte." + FIM_DE_LINHA
		+ "Suponha que o campo total eh zero, 8 cm acima de um fio longo, retilineo, " + FIM_DE_LINHA
		+ "horizontal que conduz uma corrente constante." + FIM_DE_LINHA + FIM_DE_LINHA
		+ "Determine:" + FIM_DE_LINHA + "(a) o modulo da corrente;" + FIM_DE_LINHA + "(b) a orientacao da corrente." + FIM_DE_LINHA;
	private final double PERMEABILIDADE_VACUO = 4 * Math.PI * Math.pow(10, -7);
	private double campoMagnetico = 39; //em microTesla
	private double raio = 8; //em cm;
	
	static Util util = new Util();
	
	public void menuQuestao() {
		util.inicioQuestao(nomeQuestao, enunciado);

		final int SAIR = 3;
		int opcao = 0;

		do {
			System.out.println("Escolha o que deseja fazer: ");
			System.out.println("1 - Resolver a questao original");
			System.out.println("2 - Resolver a questao com outros valor(es)");
			System.out.println("3 - Voltar");
			System.out.println("");
			
			System.out.print("Digite a opcao: ");
			opcao = util.lerInteiro();

			if (opcao == 1) {
				restauraValores();
				resolve();
				util.menuQuestao();

			} else if (opcao == 2) {
				int outraOpcao = 0;
				do {
					System.out.println("");
					System.out.println("Opcoes:");
					System.out.println("1 - Alterar raio | em cm.");
					System.out.println("2 - Alterar campo magnetico | em micro Tesla.");
					System.out.println("3 - Resolver a questao com o(s) novo(s) valor(es).");

					System.out.print("Digite a opcao: ");
					outraOpcao = util.lerInteiro();

					if (outraOpcao == 1) {
						raio = util.alterarValor("Raio");
					}
					if (outraOpcao == 2) {
						campoMagnetico = util.alterarValor("Campo magnetico");
					}

				} while (outraOpcao != 3);
				resolve();
				util.menuQuestao();
			}

		} while (opcao != SAIR);

		util.menuPrincipal();

	}

	private void resolve() {
		System.out.println("Resolucao:");
		System.out.println("(a) Temos que i = (2 x pi x r x B) / (permeabilidade do vacuo)");
		System.out.println("    Sabemos que a permeabilidade do vacuo eh (4)(pi)(10^-7)");
		double r = raio * Math.pow(10, -2);
		double B = campoMagnetico * Math.pow(10, -6);
		System.out.println("    Assim, teremos:");
		System.out.println("    i = (2 x pi)(" + util.formataNumero(r) + ")(" + util.formataNumero(B) + ") / "
				+ util.formataNumero(PERMEABILIDADE_VACUO));
		double i = Math.round((2 * Math.PI * r * B) / PERMEABILIDADE_VACUO);
		System.out.println("");
		System.out.println("    Resultando em: " + i + " A");
		System.out.println("");
		System.out.println("(b) Para produzir um campo magnetico que aponte para o sul, de modo a cancelar"
				+ FIM_DE_LINHA + " o campo magnetico da Terra, o sentido da corrente deve ser de oeste para leste.");
		System.out.println("");
	}

	private void restauraValores() {
		campoMagnetico = 39;
		raio = 8;
	}

}