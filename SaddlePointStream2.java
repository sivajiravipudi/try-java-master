import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class SaddlePointStream2 {

	public static void main(String[] args) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(inputReader.readLine());
		int[][] inputMattrix = new int[count][count];
		
		for(int i=0; i<count; i++)
		{
			String input = inputReader.readLine();
			inputMattrix[i] = Stream.of(input.split(",")).mapToInt(Integer::parseInt).toArray();
			System.out.println(Arrays.toString(inputMattrix[i]));
		}
		
		for(int i=0; i<count; i++) {
			int lowerBound = 0;
			for(int j=1; j<count; j++) {
				if(inputMattrix[i][j] < inputMattrix[i][lowerBound]) {
					lowerBound = j;					
				}
				
			}
			 boolean isSaddle=true;
			for (int k=0; k<count; k++) {
				if(inputMattrix[k][lowerBound] > inputMattrix[i][lowerBound]) {
					isSaddle = false;
					break;
				}
				
			}
			if (isSaddle)
			{
				System.out.println("Saddle Point is"+inputMattrix[i][lowerBound]);
				return;
			}
			
		}
		
		System.out.println("No Saddle Point");
		
		/*
		 * int[] minNuminRows = new int[count]; int[] maxNuminCols = new int[count]; for
		 * (int i=0; i<count; i++) { minNuminRows[i] =
		 * Arrays.stream(inputMattrix[i]).min().getAsInt(); maxNuminCols[i] =
		 * Arrays.stream(getColumn(inputMattrix, i)).max().getAsInt(); }
		 * System.out.println("min Rows"+Arrays.toString(minNuminRows));
		 * System.out.println("max Rows"+Arrays.toString(maxNuminCols));
		 * if(Arrays.stream(minNuminRows).max().getAsInt() ==
		 * Arrays.stream(maxNuminCols).min().getAsInt()) {
		 * System.out.println("SaddlePoint is"+Arrays.stream(minNuminRows).max().
		 * getAsInt()); } else { System.out.println("No Saddle Point"); }
		 */
	}
	
	
	private static int[] getColumn(int[][] columMat, int col) {
		return IntStream.range(0, columMat.length)
				.map(i->columMat[i][col]).toArray();
		
		
	}

}
