public class Main {

	public static void main(String[] args) {
		/*
		 * Este e um problema relacionado a um caixa eletronico,
		 * mais especificamente a operacao de saque de dinheiro.
		 * 
		 * Suponha que o mecanismo de saque em diferentes cedulas
		 * seja implementado usando o padrao Chain of Responsibility.
		 * 
		 * Neste contexto, deve existir um handler na cadeia para 
		 * cada valor de cedula.
		 * 
		 * SaqueHandler representa a classe base para
		 * todos os handlers de saque. 
		 * 
		 * Um handler de saque tem a responsabilidade de liberar a 
		 * quantia de dinheiro possivel considerando o valor de nota
		 * por ele gerenciado. Depois de liberar a quantia, ele
		 * direciona o restante do valor para o proximo handler
		 * para continuar o saque, caso o restante seja maior que
		 * zero. 
		 * 
		 *  Se nao for possivel prosseguir com o saque (sem proximo)
		 *  handler, este deve ser abortado
		 */
		
		SaqueHandler d10 = new Dispenser(null/*prox. handler*/, 10/*gerencia notas de 10*/);
		SaqueHandler d20 = new Dispenser(d10, 20);
		SaqueHandler d50 = new Dispenser(d20, 50);
		SaqueHandler d100 = new Dispenser(d50, 100);

		System.out.println("Sacando 370:");
		d100.handleSaque(370); // chamando a partir do dispenser de 100
		/* Saida:
		 Sacando 370:
		 Dispenser de 100: 3 notas
         Dispenser de 50: 1 notas
         Dispenser de 20: 1 notas
		 */
		
		System.out.println("\nSacando 1330:");
		d100.handleSaque(1330);
		/* Saida:
		Sacando 1330:
		Dispenser de 100: 13 notas
		Dispenser de 20: 1 notas
		Dispenser de 10: 1 notas
		*/
		
		System.out.println("\nSacando 655:");
		d100.handleSaque(655);
		/* Saida:
		Sacando 655:
		Dispenser de 100: 6 notas
		Dispenser de 50: 1 notas
		Saque abortado, sem notas compativeis. Resta: 5
		*/		
	}
}