package trabalho;

public class Main {
	
	public static void main(String[] args) {
		
		Util leitor = new Util();
		
		TerceiroEstagio terceiro = new TerceiroEstagio();
		PrimeiroEstagio primeiro = new PrimeiroEstagio();
		
		int opcao = 0;
		do {
			System.out.println("Escolha o Estagio desejado:");
			System.out.println("1 - Primeiro Estagio");
			System.out.println("2 - Terceiro Estagio");
			System.out.println("3 - Encerrar\n");
			System.out.print("Opcao: ");
			opcao = leitor.lerInteiro();
			System.out.println();

			switch (opcao) {
				case 1:
					primeiro.menuQuestao();
					break;
				case 2:
					terceiro.menuQuestao();
					break;
				case 3:
					break;
			}
		} while (opcao != 3);
	}
		
}
