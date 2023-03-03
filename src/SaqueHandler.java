public class SaqueHandler {
	
	public SaqueHandler _successor;
	private int iValorSaque = 0;

	public SaqueHandler() {
		this._successor = null;
	}

	public SaqueHandler(SaqueHandler _successor) {
		this._successor = _successor;
	}
	
	public void SetHandler(SaqueHandler _successor) {
		this._successor = _successor;
	}

	public void handleSaque(int iValor) {
		if(this._successor != null) {
			this.iValorSaque = iValor;
		}
	}
	
	public int getValorSaque() {
		return this.iValorSaque;
	}
}