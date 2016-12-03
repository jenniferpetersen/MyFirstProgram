import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	private ArrayList<Hund> hundLista = new ArrayList<>();
	private static Scanner tngtbord = new Scanner(System.in);
	
	private String l�sText(String ledtext) {
		System.out.print(ledtext);
		String str�ng = tngtbord.nextLine();
		
		//returnerar inl�st text med f�rsta bokstav som versal
		return str�ng.substring(0, 1).toUpperCase() + str�ng.substring(1);
	}

	private int l�sHeltal(String ledtext) {
		System.out.print(ledtext);
		int talet = tngtbord.nextInt();
		tngtbord.nextLine();
		return talet;
	}

	private double l�sFlyttal(String ledtext) {
		
		System.out.print(ledtext);
		double talet = tngtbord.nextDouble();
		tngtbord.nextLine();
		return talet;
	}

	private void initiera() {

		Hund Olle = new Hund("Olle", "Rottweiler", 2, 40);
		Hund Fia = new Hund("Fia", "Tax", 5, 3);
		
		hundLista.add(Fia);
		hundLista.add(Olle);
	}

	private void k�r() {

		for (;;) {
			skrivMeny();
			switch (l�sKommando()) {
			case "l":
			case "1":
				visaHundregister();
				break;
			case "r":
			case "2":
				l�ggTillHund();
				break;
			case "t":
			case "3":
				taBortHund();
				break;
			case "a":
			case "4":
				return;
			default:
				skrivFelmeddelande();
			}
		}
	}

	private void skrivMeny() {
		System.out.println("F�ljande kommandon finns:");
		System.out.println("(L)ista hundar per svansl�ngd");
		System.out.println("(R)egistrera hund");
		System.out.println("(T)a bort hund");
		System.out.println("(A)vsluta");
	}

	private String l�sKommando() {
		return l�sText("> ").toLowerCase();
	}

	private void skrivFelmeddelande() {
		System.out.println("Felaktigt kommando!");
	}

	private void visaHundregister() {
		
		double minstaSvans = l�sFlyttal("Ange minsta svansl�ngd: ");

	//Loopar igenom alla hundar i lista, om deras svans �r >= inmatad gr�ns, skriv ut hunden.	
		for (int index = 0; index < hundLista.size(); index++){
			double svansen = hundLista.get(index).getSvansL�ngd();
			
			if (svansen >= minstaSvans){
				System.out.println(hundLista.get(index));
			}
			System.out.println();
		}
	 }

	private void l�ggTillHund() {
		
		String namn = l�sText("Hundens namn: ");
		String ras = l�sText("Hundens ras: ");
		int �lder = l�sHeltal("Hundens �lder: ");
		double vikt = l�sFlyttal("Hundens vikt i kg: ");
		
		hundLista.add(new Hund(namn, ras, �lder, vikt));		
	}
	
	private void taBortHund() {

		String namn = l�sText("Ange hundens namn: ");
		boolean hittad = false;

		for (int index = 0; index < hundLista.size(); index++){
			
			boolean hundenFinnsIListan = hundLista.get(index).getNamn().equals(namn);
			
			if (hundenFinnsIListan){
				hundLista.remove(index);
				System.out.println("Hunden har tagits bort ur registret");
				hittad = true;
			}
		}
		if (!hittad){
			System.out.println("Angiven hund finns ej i registret");	
		}
	}			

	private void avsluta() {

		System.out.println("Programmet avslutas");
	}

	public static void main(String[] args) {		
		Register register = new Register();
		register.initiera();
		register.k�r();
		register.avsluta();
	}

}
