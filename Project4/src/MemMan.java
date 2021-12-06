import java.io.BufferedReader;
import java.io.FileReader;

/**
 * {Project Description Here}
 */

/**
 * The class containing the main method. Extend with your code, and update this
 * docblock
 *
 * @author {Your Name Here}
 * @version {Put Something Here}
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
     * @param args
     *             Command line parameters
     */
    public static void main(String[] args) throws Exception {
        // This is the main file for the program.
        if (args.length < 3) {
            System.out.println("Missing arguments. Must be 3");
            System.exit(1);
        }
        BufferedReader input = new BufferedReader(new FileReader(args[2]));
        try {
            String line = input.readLine();
            String[] command;
            while (line != null) {
                command = line.split(" ", 2);

                if (command[0].equals("add")) {
                    // add command
                } else if (command[0].equals("delete")) {
                    // delete command
                } else if (command[0].equals("update")) {
                    // update command
                } else {
                    // print command
                }
                line = input.readLine();
            }

        } catch (Error e) {
            System.out.println("System is invalid");
        } finally {
            input.close();
        }

    }
}
