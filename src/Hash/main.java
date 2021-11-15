package Hash;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner ScanLine = new Scanner(System.in);
		String InputLine = ScanLine.nextLine();
		ScanLine.close();
		
		HashFunction Hash = new HashFunction();
		Hash.InputText(InputLine);
		System.out.println(Hash.ReturnHash());
		

	}

}
