package automata.stats;

import java.util.ArrayList;

public class Stats {
    private ArrayList<Integer> activity = new ArrayList<>();
    private ArrayList<int[]> cellCounting = new ArrayList<>();
    
    public void addStepValues(int cellChange, int[] cellCount) {
	activity.add(cellChange);
	cellCounting.add(cellCount);
    }
}