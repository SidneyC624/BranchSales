import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your file, including the file extension: ");
		String fileName = scanner.nextLine();
		//System.out.print(fileName);
		scanner.close();
		
		double yearlySum = 0;
		// sum of yearly sum of all branches
		double[] quarterlySum = new double[4];
		int count = 0;
		File myFile = new File(fileName);
		try {
			scanner = new Scanner(myFile);
			while(scanner.hasNextDouble()) {
				double sale = scanner.nextDouble();
				yearlySum += sale;
				//quarter -> 0,1,2 or 3
				int quarter = count % 4;
				quarterlySum[quarter] += sale;
				count++;
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("There is no such file :(");
		}
		
		
		System.out.println(yearlySum);
		for(int i=0; i<4; i++) {
			System.out.println(quarterlySum[i]);
		}
	}

}
