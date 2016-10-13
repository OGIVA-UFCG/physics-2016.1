package trabalho;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Util {
	
	public Scanner scanner = new Scanner(System.in);
	
	public int lerInteiro(){
		int inteiro = scanner.nextInt();
		scanner.nextLine();
		return inteiro;
	}
	
	public double lerDouble(){
		double decimal = scanner.nextDouble();
		scanner.nextLine();
		return decimal;
	}
	
	public String lerString(){
		String string = scanner.nextLine();
		return string;
	}
	
	public String formataNumero(double numero) {
		NumberFormat formatter = new DecimalFormat();
		formatter = new DecimalFormat("0.##E0");
		String valor = formatter.format(numero);
		return valor.replace("E", " x 10^");
	}
	
	public void menuQuestao() {
		System.out.println("----Retornando ao Menu da Questao ----\n");
	}
	
	public void menuPrincipal() {
		System.out.println("----Retornando ao Menu Principal ----\n");
	}
	
	public void inicioQuestao(String nomeQuestao, String enunciadoQuestao) {
		System.out.println("= = " + nomeQuestao + " = =\n");
		System.out.println("Enunciado:\n");
		System.out.println(enunciadoQuestao + "\n");
	}
	
	public int alterarValor(String nome) {
		System.out.println("");
		System.out.print("Digite o novo valor do " + nome + ": ");
		int valor = lerInteiro();
		System.out.println(nome + " alterado(a).\n");
		return valor;
	}
	
	public void alterarCargas(double q1, double q2, double q3, double q4) {
		System.out.println("Digite o novo valor de q1: ");
		q1 = lerDouble();
		System.out.println("Digite o novo valor de q2: ");
		q2 = lerDouble();
		System.out.println("Digite o novo valor de q3: ");
		q3 = lerDouble();
		System.out.println("Digite o novo valor de q4: ");
		q4 = lerDouble();
		System.out.println("Cargas alteradas!\n");
	}

}