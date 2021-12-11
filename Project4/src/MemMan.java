import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * {Project Description Here}
 */

/**
 * The class containing the main method. Extend with your code, and update this
 * docblock
 *
 * @author Cuong Pham
 * @author Khanh Pham
 * @version 12/9/2021
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class MemMan {
	/**
	 * @param args Command line parameters
	 */
	public static void main(String[] args) throws Exception {
		// This is the main file for the program.
		if (args.length < 3) {
			System.out.println("Missing arguments. Must be 3");
			System.exit(1);
		}
		Scanner input = new Scanner(new FileReader(args[2]));
		int size = Integer.parseInt(args[1]);
		HashTable<String, Handle> hash = new HashTable<>(size);
		int size2 = Integer.parseInt(args[0]);
		MemManager man = new MemManager(size2);
		String[] check;
		while (input.hasNext()) {
			String cuong = input.nextLine();
			if (!cuong.isEmpty()) {
				String splitStr = cuong.replaceAll("^\\s+", "");
				String delims = "[ <>\t]+";
				check = splitStr.split(delims);
				if (check[0].equals("add")) {
					String output = "";
					for (int i = 1; i < check.length; i++) {
						output += check[i] + " ";
					}
					output = output.strip();
					if (hash.get(output) != null) {
						System.out.println("|" + output + "| duplicates a record already in the Name database.");
					} else {

						add(hash, output, man.insert(output.getBytes(), output.getBytes().length));
					}

				} else if (check[0].equals("print")) {
					if (check[1].equals("hashtable")) {
						hash.dump();
					} else {
						man.dump();
					}
				} else if (check[0].equals("update")) {
					if (check[1].equals("add")) {
						System.out.println("add");
					} else {
						System.out.println("delete");
					}
				} else if (check[0].equals("delete")) {
					String output = "";
					for (int i = 1; i < check.length; i++) {
						output += check[i] + " ";
					}
					output = output.strip();
					hash.delete(output);
				}
			}
		}

	}

	public static void add(HashTable<String, Handle> hash, String command, Handle hand) {
		hash.add(command, hand);
	}

}
