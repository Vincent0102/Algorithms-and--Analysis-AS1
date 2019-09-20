import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

/**
 * Demonstrate the different sorting algorithms.
 * 
 * @author jefcha
 */
public class PerfAnalyser {
	protected static final String progName = "PerfAnalyser";

	/**
	 * Print usage information.
	 * 
	 * @param progName Program name.
	 */
	protected static void printUsage(String progName) {
		System.err.println("USAGE: " + progName + " [implementation type] [scenario] [data size] [case]");
		System.err.println("  implementation types [bst, hash, linkedlist, sortedlinkedlist, baltree]");
		System.out.println("\n  Scenario? [a, b, c ,d]");
		System.out.println(
				"  [a]: add only, [b] remove only (after growing), [c]: add+remove (50% data each operation), [d] search only (after growing, another dataset with size of 120% will be used to search the multiset)");
		System.out.println("\n  Data size? [small, medium, large]");
		System.out.println("  [small]: n = 1234, [medium]: n = 12345, [large]: n = 123456");
		System.out.println("\n  Case? [best, worst, random]");
		System.out.println(
				"  [best]: data sorted ascendingly, [worst]: data sorted descendingly, [random]: unsorted random data.");
		System.err.println("EXAMPLE: " + progName + " linkedlist best large random");
	} // end of printUsage()

	/**
	 * Main method.
	 * 
	 * @param args Command line arguments.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		double timeElapsed = 0;
		Integer[] addSamples = null;
		Integer[] searchSamples = null;
		Integer[] removeSamples = null;
		Scanner sc = new Scanner(System.in);

		try {
			// not enough arguments
			if (args.length != 4) {
				printUsage(progName);
				System.exit(1);
			}
			String implementationType = args[0];
			String scenario = args[1];
			String size = args[2];
			String useCase = args[3];
			
			// figure out with sorting algorithm we are using
			Multiset multiset = null;
			switch (implementationType) {
			case "linkedlist":
			
					multiset = new LinkedListMultiset();

				break;
			case "sortedlinkedlist":
				
					multiset = new SortedLinkedListMultiset();
				
				break;
			case "bst":
				
					multiset = new BstMultiset();
				
				break;
			case "hash":
				
					multiset = new HashMultiset();
				
				break;
			case "baltree":
				
					multiset = new BalTreeMultiset();
				
				break;
			default:
				System.err.println("Error: " + implementationType + " is invalid.");
				printUsage(progName);
				System.exit(1);
			}

			System.out.println(
					"Thanks for using Performance Analyser, a program written for AA A1 to analyse the performance of your selected data structure.");

			
			

			String addFile = null;
			String removeFile = null;
			String searchFile = null;
			boolean timeBoth = false;

			if (scenario.equalsIgnoreCase("a") && size.equalsIgnoreCase("small")) {
				addFile = "generation/data/addSmall.ser";

			} else if (scenario.equalsIgnoreCase("a") && size.equalsIgnoreCase("medium")) {
				addFile = "generation/data/addMedium.ser";
			} else if (scenario.equalsIgnoreCase("a") && size.equalsIgnoreCase("large")) {
				addFile = "generation/data/addLarge.ser";
			} else if (scenario.equalsIgnoreCase("b") && size.equalsIgnoreCase("small")) {
				addFile = "generation/data/addSmall.ser";
				removeFile = "generation/data/removeSmall.ser";
			} else if (scenario.equalsIgnoreCase("b") && size.equalsIgnoreCase("medium")) {
				addFile = "generation/data/addMedium.ser";
				removeFile = "generation/data/removeMedium.ser";
			} else if (scenario.equalsIgnoreCase("b") && size.equalsIgnoreCase("large")) {
				addFile = "generation/data/addLarge.ser";
				removeFile = "generation/data/removeLarge.ser";
			} else if (scenario.equalsIgnoreCase("c") && size.equalsIgnoreCase("small")) {
				addFile = "generation/data/addRemoveSmall.ser";
				removeFile = "generation/data/removeAddSmall.ser";
				timeBoth = true;
			} else if (scenario.equalsIgnoreCase("c") && size.equalsIgnoreCase("medium")) {
				addFile = "generation/data/addRemoveMedium.ser";
				removeFile = "generation/data/removeAddMedium.ser";
				timeBoth = true;
			} else if (scenario.equalsIgnoreCase("c") && size.equalsIgnoreCase("large")) {
				addFile = "generation/data/addRemoveLarge.ser";
				removeFile = "generation/data/removeAddLarge.ser";
				timeBoth = true;
			} else if (scenario.equalsIgnoreCase("d") && size.equalsIgnoreCase("small")) {
				addFile = "generation/data/addSmall.ser";
				searchFile = "generation/data/searchSmall.ser";
			} else if (scenario.equalsIgnoreCase("d") && size.equalsIgnoreCase("medium")) {
				addFile = "generation/data/addMedium.ser";
				searchFile = "generation/data/searchMedium.ser";
			} else if (scenario.equalsIgnoreCase("d") && size.equalsIgnoreCase("large")) {
				addFile = "generation/data/addLarge.ser";
				searchFile = "generation/data/searchLarge.ser";
			} else {
				System.err.println("Please input correctly!");
				System.exit(1);
			}

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(addFile));
			addSamples = (Integer[]) in.readObject();
			in.close();

			if (removeFile != null) {
				ObjectInputStream inA = new ObjectInputStream(new FileInputStream(removeFile));
				removeSamples = (Integer[]) inA.readObject();
				inA.close();
			}

			if (searchFile != null) {
				ObjectInputStream inB = new ObjectInputStream(new FileInputStream(searchFile));
				searchSamples = (Integer[]) inB.readObject();
				inB.close();
			}

			
			switch (useCase) {
			case "best":
				Arrays.sort(addSamples);
				if (searchSamples != null) {
					Arrays.sort(searchSamples);
				}

				if (removeSamples != null) {
					Arrays.sort(removeSamples);
				}
				break;
			case "worst":
				Arrays.sort(addSamples, Collections.reverseOrder());
				if (searchSamples != null) {
					Arrays.sort(searchSamples, Collections.reverseOrder());
				}

				if (removeSamples != null) {
					Arrays.sort(removeSamples, Collections.reverseOrder());
				}

				break;
			case "random":
				break;
			default:
				System.err.println("Error: " + useCase + " is invalid.");
				System.exit(1);
			}

			System.out.println("\nComputing...\n");

				long startTime, endTime;
				if (timeBoth == true) {
					startTime = System.nanoTime();
					for (int i = 0; i < addSamples.length; i++) {
						multiset.add(addSamples[i]);
					}
					
					for (int i = 0; i < removeSamples.length; i++) {
						multiset.removeOne(removeSamples[i]);
					}
					endTime = System.nanoTime();
					
				} else if (searchSamples != null && removeSamples == null && timeBoth == false) {
					for (int i = 0; i < addSamples.length; i++) {
						multiset.add(addSamples[i]);
					}
					startTime = System.nanoTime();
					for (int i = 0; i < searchSamples.length; i++) {
						multiset.search(searchSamples[i]);
					}
					endTime = System.nanoTime();
				} else if (searchSamples == null && removeSamples != null && timeBoth == false) {
					for (int i = 0; i < addSamples.length; i++) {
						multiset.add(addSamples[i]);
					}
					startTime = System.nanoTime();
					for (int i = 0; i < removeSamples.length; i++) {
						multiset.removeOne(removeSamples[i]);
					}
					endTime = System.nanoTime();
				} else {
					startTime = System.nanoTime();
					for (int i = 0; i < addSamples.length; i++) {
						multiset.add(addSamples[i]);
					}
					endTime = System.nanoTime();
				}
				
				
				timeElapsed = (endTime - startTime) / Math.pow(10, 9);

			System.out.println("Time elapsed (secs) for chosen operation: \n" + timeElapsed + "\n");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			printUsage(progName);
		}

		sc.close();

	} // end of main()

} // end of class SortDemo1
