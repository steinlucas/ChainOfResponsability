public class Dispenser extends SaqueHandler {

	private int iValorNota;
	
	public Dispenser(SaqueHandler saqHandler, int iValor) {
		this.iValorNota = iValor;
		
		if (saqHandler != null)
			super.SetHandler(saqHandler);
	}
	
	@Override
	public void handleSaque(int iValor) {
		
		if (iValor >= this.iValorNota) {
			int notas = iValor / this.iValorNota;
            int restante = iValor % this.iValorNota;

            System.out.println("Dispenser de " + this.iValorNota + ": " + notas + " notas");
            
            if (restante != 0)
            	super._successor.handleSaque(restante);
		} else {
			if (super._successor != null)
				super._successor.handleSaque(iValor);
			else
				System.out.println("Saque abortado, sem notas compativeis. Resta: " + iValor);
		}
	}
}