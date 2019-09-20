import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

public class Printer {

	public Printer()
	{
		
	}
	
	public static void print() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		PrintWriter pw;
		ObjectInputStream in;
		Integer[] addSamples = null;
		in = new ObjectInputStream(new FileInputStream("data/addLarge.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/addLarge.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/addMedium.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/addMedium.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/addRemoveLarge.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/addRemoveLarge.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		
		in = new ObjectInputStream(new FileInputStream("data/addRemoveMedium.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/addRemoveMedium.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/addRemoveSmall.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/addRemoveSmall.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/addSmall.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/addSmall.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		
		in = new ObjectInputStream(new FileInputStream("data/removeAddLarge.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/removeAddLarge.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/removeAddMedium.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/removeAddMedium.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();

		in = new ObjectInputStream(new FileInputStream("data/removeAddSmall.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/removeAddSmall.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/removeLarge.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/removeLarge.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/removeMedium.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/removeMedium.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/removeSmall.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/removeSmall.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/searchLarge.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/searchLarge.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/searchMedium.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/searchMedium.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		in = new ObjectInputStream(new FileInputStream("data/searchSmall.ser"));
		addSamples = (Integer[]) in.readObject();
		pw = new PrintWriter (new FileOutputStream("data/searchSmall.txt"));
		for (int i = 0; i < addSamples.length; i++)
		{
			pw.println(addSamples[i]);
		}
		in.close();
		pw.close();
		
		System.out.println("Print to .txt success! Please refresh the folder.");
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		print();
	}

}
