package exceptionPackage;

public class ContoCorrente {
	public String titolare;
	public int nMovimenti;
	public final int maxMovimenti = 50;
	public double saldo;

	public ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) throws BancaException {
		if (nMovimenti < maxMovimenti)
			saldo = saldo - x;
		else {

			saldo = saldo - x - 0.50;
			if (saldo < 0) {
				nMovimenti++;
				throw new BancaException("il conto è in rosso");
			}

		}
	}

	double restituisciSaldo() {
		return saldo;
	}
}
