package exceptionPackage;

public class ContoOnline extends ContoCorrente {
	double maxPrelievo;

	public ContoOnline(String titolare, double saldo, double maxPrelievo) {
		super(titolare, saldo);
		this.maxPrelievo=maxPrelievo;
	}


	void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	void preleva(double x) throws BancaException {
		if (x <= maxPrelievo) {
			super.preleva(x);
		}else if(x>maxPrelievo){
			throw new BancaException("il prelievo non è disponibile");
		}
	}
}
