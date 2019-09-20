import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * Generates collection of integers from sampling a uniform distribution.
 * 
 * @author jkcchan
 * 
 * modified by s3688090
 */
public class DataGenerator
{
	
	/** Start of integer range to generate values from. */
	protected int mStartOfRange;
	/** End of integer range to generate values from.  	*/
	protected int mEndOfRange;
	/** Random generator to use. */
	Random mRandGen;
	
	
	/**
	 * Constructor.
	 * 
	 * @param startOfRange Start of integer range to generate values.
	 * @param endOfRange End of integer range to generate values.
	 * @throws IllegalArgumentException If range of integers is inappropriate
	 */
	public DataGenerator(int startOfRange, int endOfRange) {
		mStartOfRange = startOfRange;
		mEndOfRange = endOfRange;
		// use current time as seed
		mRandGen = new Random(System.currentTimeMillis());
	} // end of DataGenerator()
	
	
	/**
	 * Generate one sample, using sampling with replacement.
	 */
	public int sampleWithReplacement() {
		return mRandGen.nextInt(mEndOfRange - mStartOfRange + 1) + mStartOfRange;
	} // end of sampleWithReplacement()
	
	
	/**
	 * Generate 'sampleSize' number of samples, using sampling with replacement.
	 * 
	 * @param sampleSize Number of samples to generate.
	 */
	public Integer[] sampleWithReplacement(int sampleSize) {
		Integer[] samples = new Integer[sampleSize];
		
		for (int i = 0; i < sampleSize; i++) {
			samples[i] = sampleWithReplacement();
		}
		
		return samples;
	} // end of sampleWithReplacement()
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Running this program may/will override the existing data. Are you sure you'd like to continue? [yes/no]");
		String confirm = sc.next();
		
		if (!(confirm.equalsIgnoreCase("yes")))
		{
			System.out.println("Bye");
			System.exit(1);
		}
		
		System.out.println("Are you 100% sure you'd like to proceed? [confirm/quit]");
		String confirmA = sc.next();
		
		if (!(confirmA.equalsIgnoreCase("confirm")))
		{
			System.out.println("Bye");
			System.exit(1);
		}

		System.out.println("Let's generate some stuff... and give it a few moment alright?");
		
		DataGenerator dataGenSmall = new DataGenerator(1, 1234);
		DataGenerator dataGenMedium = new DataGenerator(1, 12345);
		DataGenerator dataGenLarge = new DataGenerator(1, 123456);
		
		Integer [] dataArray = null;
		
		dataArray = dataGenSmall.sampleWithReplacement(1234);
		
		 try{
	         FileOutputStream fos= new FileOutputStream("data/addSmall.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenMedium.sampleWithReplacement(12345);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/addMedium.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenLarge.sampleWithReplacement(123456);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/addLarge.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenSmall.sampleWithReplacement(1234);
			
		 try{
	         FileOutputStream fos= new FileOutputStream("data/removeSmall.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenMedium.sampleWithReplacement(12345);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/removeMedium.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenLarge.sampleWithReplacement(123456);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/removeLarge.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenSmall.sampleWithReplacement(617);
			
		 try{
	         FileOutputStream fos= new FileOutputStream("data/addRemoveSmall.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenMedium.sampleWithReplacement(6172);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/addRemoveMedium.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenLarge.sampleWithReplacement(61728);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/addRemoveLarge.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenSmall.sampleWithReplacement(617);
			
		 try{
	         FileOutputStream fos= new FileOutputStream("data/removeAddSmall.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenMedium.sampleWithReplacement(6172);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/removeAddMedium.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenLarge.sampleWithReplacement(61728);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/removeAddLarge.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenSmall.sampleWithReplacement(1481);
			
		 try{
	         FileOutputStream fos= new FileOutputStream("data/searchSmall.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenMedium.sampleWithReplacement(14814);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/searchMedium.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 dataArray = dataGenLarge.sampleWithReplacement(148147);
		 
		 try{
	         FileOutputStream fos= new FileOutputStream("data/searchLarge.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(dataArray);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
		 System.out.println("Data has been generated and ready to be used with Performance Analyser! Please give the folder a refresh.");
		 
		 try {
			Printer.print();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}		
	
} // end of class DataGenerator
