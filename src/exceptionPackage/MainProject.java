package exceptionPackage;

import java.util.Scanner;

public class MainProject {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		esercizioUno();
		esercizioDue();
		try {
			esercizioTre();
		} catch (BancaException e) {
			System.out.println("ERRORE!");
		}

	}

	public static void esercizioUno() {
		boolean uscita = false;
		System.out.println("Scegli una posizione in cui andare a cambiare il numero ('0' -> per uscire)");
		int insiemeNumeri[] = new int[5];

		for (int i = 0; i < insiemeNumeri.length; i++) {
			insiemeNumeri[i] = (int) (Math.random() * 10 + 1);
			System.out.println((i + 1) + ": " + insiemeNumeri[i]);
		}

		do {
			try {
				System.out.println("Scegli una posizione in cui andare a cambiare il numero ('0' -> per uscire)");
				// uscita=false;
				int n = Integer.parseInt(sc.nextLine());
				if (n >= 1 && n <= 5) {
					boolean numeroValido;
					do {
						numeroValido = false;
						System.out.println("Digitare un numero da 1 a 10");
						int numeroRimpiazzo = Integer.parseInt(sc.nextLine());
						if (numeroRimpiazzo >= 1 && numeroRimpiazzo <= 10) {
							insiemeNumeri[n - 1] = numeroRimpiazzo;
							numeroValido = true;
							for (int i = 0; i < insiemeNumeri.length; i++) {
								System.out.println((i + 1) + ": " + insiemeNumeri[i]);
							}
						}
					} while (!numeroValido);
				} else if (n == 0) {
					System.out.println("Grazie per aver utilizzato il sistema di rimpiazzo numeri arrivederci!");
					uscita = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("ERRORE! Inserire un numero non valido ");
			} catch (Exception e) {
				System.out.println("ERRORE! ");
			}

		} while (!uscita);

	}

	public static void esercizioDue() {
		boolean uscitaEsercizioDue = false;

		do {
			try {
				System.out.println("Inserire i km percorsi ('q' -> per uscire)");
				String chilometri = sc.nextLine();
				if (chilometri.equals("q")) {
					System.out.println(
							"Grazie per aver utilizzato il sistema di calcolo di consumo di litro al chilometro!");
					uscitaEsercizioDue = true;
				} else {
					int chilometraggio = Integer.parseInt(chilometri);
					System.out.println("Inserire i litri di carburante consumati");
					int carburanteConsumato = Integer.parseInt(sc.nextLine());
					System.out.println("Hai consumato :" + (chilometraggio / carburanteConsumato) + " l/km");
				}
			} catch (NumberFormatException e) {
				System.out.println("Valore non valido inserire un numero");
			} catch (ArithmeticException e) {
				System.out.println("Non puoi inserire '0' come litri consumati");
			} catch (Exception e) {
				System.out.println("ERRORE! ");
			}
		} while (!uscitaEsercizioDue);
	}

	public static void esercizioTre() throws BancaException {

		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(550000.0);

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
			e.printStackTrace();
		}

		ContoOnline conto2 = new ContoOnline("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(70000);

			conto2.stampaSaldo();

		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}

	}
}
