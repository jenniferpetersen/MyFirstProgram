import java.util.ArrayList;
import java.util.Scanner;

public class Register {
	private ArrayList<Hund> hundLista = new ArrayList<>();
	private static Scanner tngtbord = new Scanner(System.in);
	
	private String läsText(String ledtext) {
		System.out.print(ledtext);
		String sträng = tngtbord.nextLine();
		
		//returnerar inläst text med första bokstav som versal
		return sträng.substring(0, 1).toUpperCase() + sträng.substring(1);
	}

	private int läsHeltal(String ledtext) {
		System.out.print(ledtext);
		int talet = tngtbord.nextInt();
		tngtbord.nextLine();
		return talet;
	}

	private double läsFlyttal(String ledtext) {
		
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

	private void kör() {

		for (;;) {
			skrivMeny();
			switch (läsKommando()) {
			case "l":
			case "1":
				visaHundregister();
				break;
			case "r":
			case "2":
				läggTillHund();
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
		System.out.println("Följande kommandon finns:");
		System.out.println("(L)ista hundar per svanslängd");
		System.out.println("(R)egistrera hund");
		System.out.println("(T)a bort hund");
		System.out.println("(A)vsluta");
	}

	private String läsKommando() {
		return läsText("> ").toLowerCase();
	}

	private void skrivFelmeddelande() {
		System.out.println("Felaktigt kommando!");
	}

	private void visaHundregister() {
		
		double minstaSvans = läsFlyttal("Ange minsta svanslängd: ");

	//Loopar igenom alla hundar i lista, om deras svans är >= inmatad gräns, skriv ut hunden.	
		for (int index = 0; index < hundLista.size(); index++){
			double svansen = hundLista.get(index).getSvansLängd();
			
			if (svansen >= minstaSvans){
				System.out.println(hundLista.get(index));
			}
			System.out.println();
		}
	 }

	private void läggTillHund() {
		
		String namn = läsText("Hundens namn: ");
		String ras = läsText("Hundens ras: ");
		int ålder = läsHeltal("Hundens ålder: ");
		double vikt = läsFlyttal("Hundens vikt i kg: ");
		
		hundLista.add(new Hund(namn, ras, ålder, vikt));		
	}
	
	private void taBortHund() {

		String namn = läsText("Ange hundens namn: ");
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
		register.kör();
		register.avsluta();
	}

}
