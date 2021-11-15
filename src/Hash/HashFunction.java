package Hash;

import java.util.ArrayList;

public class HashFunction {
	
	String text;
	
	public void InputText(String text) { this.text = text; }
	
	public String ReturnHash() {
		
		ArrayList<Integer> ListBytes = new ArrayList<>();
		for (int i = 0; i < text.length(); i ++) ListBytes.add( (int) text.charAt(i) );
		if (ListBytes.size() < 8) {
			
			int j = 0;
			for(int i = ListBytes.size(); i < 8; i ++) {
				ListBytes.add( ListBytes.get(j) + ListBytes.get(j+1) );
				
				j++;
				
				}
		
			}

		for (int i = 0; i < ListBytes.size(); i ++) {
			
			int SqrtByte = (int) (Math.sqrt(ListBytes.get(i)) * 1000);
			ListBytes.set(i, SqrtByte);
			
		}
		
		StringBuilder Hash = new StringBuilder();

		while (ListBytes.size() > 8) {
			
			ArrayList<Integer> Middle = new ArrayList<>();
			for (int i = 0; i < ListBytes.size()-1; i ++) Middle.add(ListBytes.get(i) * ListBytes.get(ListBytes.size()- (i+1)) % 571);
			ListBytes = Middle;
			
			
		}
		
		
		for (int i = 0; i < 8; i ++) {
			
			Hash.append( (char) ReturnCharacter(ListBytes.get(i)) );
			
		}
		
		return Hash.toString();
			
		
	}
	
private int ReturnCharacter(int Char) {
		
		while ( ! ( ((Char <= 57) && (Char >= 48)) || ((Char <= 70) && (Char >= 65)) ) ) {
			
			if (Char < 48) 
						Char += 40;
			
			else 
						Char -= 30;
			
		}
		
		return Char;
		
	}
	
}
