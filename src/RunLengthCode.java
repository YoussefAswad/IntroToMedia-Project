
import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import java.awt.image.Raster;

import javax.imageio.ImageIO; 


public class RunLengthCode {

	private static String ComputeCode(int[][] imgArr){
		String RLC = "";
		// write your logic here 
		for(int h = 0; h < imgArr[0].length;h++) {
			for(int w = 0; w < imgArr.length;w++) {
				if(imgArr[w][h] == 1) {
					if(RLC == "" || RLC.charAt(RLC.length()-1) == ')' ) {
						RLC = RLC + "("+ h;
					}
					RLC = RLC + " " + w;
					while(w < imgArr.length && imgArr[w][h] == 1) {
						w++;
					}
					RLC = RLC + " " + --w;
				}
			}
			if(RLC != "" && RLC.charAt(RLC.length()-1) != ')') {
				RLC = RLC + ")";
			}
		}	
		return RLC;
	}
	
	public static void main(String [] args) {
		//write image path 
		String path = "Input/binary_line.jpg";
		
		BufferedImage image = null;
		
		try {
			
			File input_image = new File(path);
			// Reading input image 
		    image = ImageIO.read(input_image);
		    System.out.println("Reading complete."); 
		} 
		
		catch (IOException e) {
		}
		
		// convert image to 2D array 
		int width = image.getWidth();
	    int height = image.getHeight();
	    int[][] imgArr = new int[width][height];
	    Raster raster = image.getData();
	    for (int i = 0; i < width; i++) {
	        for (int j = 0; j < height; j++) {
	            imgArr[i][j] = raster.getSample(i, j, 0);
	            
	        }
	    }
		
	    
		// print run length Code 
		System.out.println(ComputeCode(imgArr));
		
	}//main ends here
	
}// class ends here 


