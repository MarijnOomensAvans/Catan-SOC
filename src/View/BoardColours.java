package View;

import java.awt.Color;

public enum BoardColours {
	DESERT(249, 239, 34),
	WOOD(8, 86, 1),
	WOOL(33, 226, 15),
	ORE(89, 102, 88),
	BRICK(163, 77, 8),
	SEA(0, 191, 255),
	GRAIN(229, 161, 43),
	STANDARD(255,255,255);
	
	private final int r;
	private final int g;
	private final int b;
	
	private BoardColours(final int r,final int g,final int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
	
	public Color getRGB() {
        return new Color(r, g, b);
    }

	
	
}
