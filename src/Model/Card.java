package Model;

public class Card {
	
	
	private String Material;
	private int KindOfMaterial;

	public Card(int kind) {
		KindOfMaterial = kind;
		setMaterial();
	}
	
	
	public String getMaterial() {
		return Material;
	}

	public void setMaterial() {
		if(KindOfMaterial == 1) {
			Material = "Hout";
		}
		else if (KindOfMaterial == 2) {
			Material = "Erts";
		}
		else if (KindOfMaterial == 3) {
			Material ="Wol";
		}
		else if(KindOfMaterial == 4) {
			Material = "Baksteen";
		}
		else if(KindOfMaterial == 5) {
			Material = "Graan";
		}
	}

	public int getKindOfMaterial() {
		return KindOfMaterial;
	}



}
