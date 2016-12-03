public class Hund {
	
	private String namn;
	private String ras;
	private int Âlder;
	private double vikt;
	private double svansL‰ngd;
	
	public Hund (String namn, String ras, int Âlder, double vikt){
		this.namn = namn;
		this.ras = ras;
		this.Âlder = Âlder;
		this.vikt = vikt;
		setSvansL‰ngd();
	}

	public String getNamn() {
		return namn;
	}

	public String getRas() {
		return ras;
	}

	public void set≈lder(int Âlder) {
		this.Âlder = Âlder;
		setSvansL‰ngd();
	}
	
	public int get≈lder() {
		return Âlder;
	}

	public double getVikt() {
		return vikt;
	}

	public void setVikt(double vikt) {
		this.vikt = vikt;
		setSvansL‰ngd();
	}

	public double getSvansL‰ngd() {
		return svansL‰ngd;
	}

	private void setSvansL‰ngd() {
		if (ras.equalsIgnoreCase("tax")){
			svansL‰ngd = 3.7;
		}
		else {
			svansL‰ngd = ((Âlder * vikt) / 10);
		}
	}
	
	public String toString(){
		return "Namn: " + namn + " Ras: " + ras + " ≈lder: " + Âlder + " Vikt: " + vikt + " Svansl‰ngd: " + svansL‰ngd;
	}
	
	

}
