package util;

import java.awt.Color;

public final class MiscUtil {
    

    
    public static Color colorFromState(int state, int numStates) {
	return Color.getHSBColor(
		(float)state / numStates, 
		1,
		0.76f);
    }
}