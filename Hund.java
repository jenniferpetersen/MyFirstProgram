public class Hund {
	
	private String namn;
	private String ras;
	private int �lder;
	private double vikt;
	private double svansL�ngd;
	
	public Hund (String namn, String ras, int �lder, double vikt){
		this.namn = namn;
		this.ras = ras;
		this.�lder = �lder;
		this.vikt = vikt;
		setSvansL�ngd();
	}

	public String getNamn() {
		return namn;
	}

	public String getRas() {
		return ras;
	}

	public void set�lder(int �lder) {
		this.�lder = �lder;
		setSvansL�ngd();
	}
	
	public int get�lder() {
		return �lder;
	}

	public double getVikt() {
		return vikt;
	}

	public void setVikt(double vikt) {
		this.vikt = vikt;
		setSvansL�ngd();
	}

	public double getSvansL�ngd() {
		return svansL�ngd;
	}

	private void setSvansL�ngd() {
		if (ras.equalsIgnoreCase("tax")){
			svansL�ngd = 3.7;
		}
		else {
			svansL�ngd = ((�lder * vikt) / 10);
		}
	}
	
	public String toString(){
		return "Namn: " + namn + " Ras: " + ras + " �lder: " + �lder + " Vikt: " + vikt + " Svansl�ngd: " + svansL�ngd;
	}
	
	

}
