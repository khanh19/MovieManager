
import java.io.FileReader;
import java.util.ArrayList;
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
				String splitStr = cuong.replaceAll("^\s+", "");
				String delims = "[ <>\t]+";
				check = splitStr.split(delims);
				if (check[0].equals("add")) {
					String output = "";
					for (int i = 1; i < check.length; i++) {
						output += check[i] + " ";
					}
					output = output.strip();
					if (hash.add(output, man.insert(output.getBytes(), output.getBytes().length))) {
						System.out.println("|" + output + "| has been added to the Name database.");
					} else {
						System.out.println("|" + output + "| duplicates a record already" + " in the Name database.");
					}

				} else if (check[0].equals("print")) {
					if (check[1].equals("hashtable")) {
						hash.dump();
					} else {
						man.dump();
					}
				} else if (check[0].equals("update")) {
					if (check[1].equals("add")) {
						ArrayList<Integer> checkSep = new ArrayList<Integer>();
						boolean valid = false;
						for (int i = 2; i < check.length; i++) {
							if (check[i].equals("SEP")) {
								checkSep.add(i);
								valid = true;
							}
						}
						if (valid) {
							String name = "";
							for (int i = 2; i < checkSep.get(0); i++) {
								name = name + check[i];
								if (i != (checkSep.get(0) - 1)) {
									name = name + " ";
								}
							}

							String fieldName = "";
							for (int i = checkSep.get(0) + 1; i < checkSep.get(1); i++) {
								fieldName = fieldName + check[i];

								if (i != (checkSep.get(1) - 1)) {
									fieldName = fieldName + " ";
								}
							}
							String fieldValue = "";
							for (int i = checkSep.get(1) + 1; i < check.length; i++) {
								fieldValue = fieldValue + check[i];
								if (i != (check.length - 1)) {
									fieldValue = fieldValue + " ";
								}
							}
							Handle handle = hash.get(name);
							if (handle == null) {
								System.out.println("|" + name + "| not updated because it does"
										+ " not exist in the Name database.");
							} else {
								hash.delete(name);
								String updateAdd = man.getRecord(handle);
								man.remove(handle);
								boolean hasField = false;

								String[] temps = updateAdd.split("<SEP>");
								for (int i = 0; i < temps.length; i++) {
									if (i % 2 == 1 && temps[i].equals(fieldName)) {
										hasField = true;

									}
								}
								if (hasField) {
									String temp1 = "";
									for (int i = 0; i < temps.length; i++) {

										if (!temps[i].equals(fieldName)) {
											temp1 += temps[i] + "<SEP>";
										} else {

											i++;
										}
									}
									temp1 = temp1.substring(0, temp1.length() - 5);
									updateAdd = temp1;
								}
								updateAdd = updateAdd + "<SEP>" + fieldName + "<SEP>" + fieldValue;
								Handle updatedHandle = man.insert(updateAdd.getBytes(), updateAdd.getBytes().length);
								hash.add(name, updatedHandle);
								System.out.println("Updated Record: |" + updateAdd + "|");

							}
						}

					} else {
						ArrayList<Integer> checkSep = new ArrayList<Integer>();
						boolean isValid = false;
						for (int i = 2; i < check.length; i++) {

							if (check[i].equals("SEP")) {
								checkSep.add(i);
								isValid = true;
							}
						}
						if (isValid) {
							if (checkSep.size() != 0) {
								String name = "";
								for (int i = 2; i < checkSep.get(0); i++) {
									name = name + check[i];
									if (i != (checkSep.get(0) - 1)) {
										name = name + " ";
									}
								}

								String fieldName = "";
								for (int i = checkSep.get(0) + 1; i < check.length; i++) {
									if (check[i].equals("SEP")) {
										check[i] = "<SEP>";
									}
									fieldName = fieldName + check[i];

									if (i != (check.length - 1)) {
										fieldName = fieldName + " ";
									}
								}

								Handle handle = hash.get(name);
								if (handle == null) {

									System.out.print("|" + name + "| not updated because it does"
											+ " not exist in the Name database." + "\n");
								} else {

									String deleteStr = name;

									boolean hasField = false;
									String[] temps = deleteStr.split("<SEP>");
									for (int i = 0; i < temps.length; i++) {
										if (i % 2 == 1 && temps[i].equals(fieldName)) {
											hasField = true;

										}
									}

									if (hasField) {
										String temp1 = "";
										for (int i = 0; i < temps.length; i++) {
											if (!temps[i].equals(fieldName)) {
												temp1 += temps[i] + "<SEP>";
											} else {
												i++;
											}
										}
										temp1 = temp1.substring(0, temp1.length() - 5);
										deleteStr = temp1;
										man.remove(handle);
										hash.delete(name);
										Handle hanInsert = man.insert(deleteStr.getBytes(),
												deleteStr.getBytes().length);
										hash.add(name, hanInsert);
										System.out.println("Updated Record: |" + deleteStr + "|");
									} else {

										System.out.println("|" + name + "| not updated" + " because the field |"
												+ fieldName + "| does not exist");
									}
								}
							}
						}
					}
				} else if (check[0].equals("delete")) {
					String output = "";
					for (int i = 1; i < check.length; i++) {
						output += check[i] + " ";
					}
					output = output.strip();
					if (hash.delete(output) != null) {
						System.out.println("|" + output + "| has been deleted from the Name database.");
					} else {
						System.out.println(
								"|" + output + "| not deleted because it does not exist in the Name database.");
					}
				} else {
					System.out.print("");
				}
			}
		}

	}

}
