package mez.javacc.info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameInfo {
	
	private int gChips, gLevel, gTime = 110;
	private String[] chips = new String[3], level = new String[3], time = new String[3];
	
	public int lockUpdate = 480000000;
	
	public void update() {
		
		if(lockUpdate == 0) {
			
			if(gTime != 0) {
				
				Integer[] digits = getDigits(gTime);
				
				if(gTime >= 100) {
					
					time[2] = digits[0] + "";
					time[1] = digits[1] + "";
					time[0] = digits[2] + "";
					
				}
				
				if(gTime < 100 && gTime >= 10) {
					
					time[2] = 0 + "";
					time[1] = digits[0] + "";
					time[0] = digits[1] + "";
					
				}
				
				if(gTime < 10 && gTime >= 1){
					
					time[2] = 0 + "";
					time[1] = 0 + "";
					time[0] = digits[0] + "";
					
				}
				
				if(gTime < 1){
					
					time[2] = 0 + "";
					time[1] = 0 + "";
					time[0] = 0 + "";
					
				}
				
				System.out.println(Arrays.toString(time));
				gTime--;
				lockUpdate = 475000000;
				return;
				
			}
			
		}
		
		else lockUpdate--;
		
	}
	
	public static Integer[] getDigits(int num) {
		
		List<Integer> digits = new ArrayList<Integer>();
		collectDigits(num, digits);
		return digits.toArray(new Integer[]{});
		
	}
	
	private static void collectDigits(int num, List<Integer> digits) {
		
		if(num / 10 > 0) collectDigits(num / 10, digits);
		digits.add(num % 10);
		
	}
	
	public void setInfo(int level, int time, int chips) {
		
		gLevel = level;
		gTime = time;
		gChips = chips;
		
	}
	
	public int getChips() { return gChips; }
	
	public int getLevel() { return gLevel; }
	
	public int getTime() { return gTime; }
	
}