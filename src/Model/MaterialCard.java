package Model;

public class MaterialCard {
	
	
	private String Material;
	private char KindOfMaterial;

	public MaterialCard(char c) {
		KindOfMaterial = c;
		setMaterial();
	}
	
	
	public String getMaterial() {
		return Material;
	}

	public void setMaterial() {
		if(KindOfMaterial == 'H') {
			Material = "Hout";
		}
		else if (KindOfMaterial == 'E') {
			Material = "Erts";
		}
		else if (KindOfMaterial == 'W') {
			Material ="Wol";
		}
		else if(KindOfMaterial == 'B') {
			Material = "Baksteen";
		}
		else if(KindOfMaterial == 'G') {
			Material = "Graan";
		}
	}

	public int getKindOfMaterial() {
		return KindOfMaterial;
	}



}
