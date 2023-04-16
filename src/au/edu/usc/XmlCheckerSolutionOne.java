package au.edu.usc;

import java.io.*;
import java.util.*;

public class XmlCheckerSolutionOne {

    public static boolean checkXml(String s) {
        Stack<String> buffer = new Stack<>();

        boolean rootValid = true; //Used to check whether the xml has only one root tag.
        int open = s.indexOf('<');
        while(open != -1) { //Checks whether open bracket was found

            int close = s.indexOf('>', open+1);

            if(close == -1) return false; //ERROR: TAG SYNTAX.
            else if(!rootValid && buffer.isEmpty()) return false; //ERROR: MULTIPLE ROOT TAGS FOUND.
            else rootValid = false; //Lets the

            Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(s.substring(open + 1, close).split(" ")));
            String tag = tagContentQ.remove();

            while(!tagContentQ.isEmpty()) {
                String att = tagContentQ.remove();
                String value = att.substring(att.indexOf("=") + 1);
                if(!value.startsWith("\"") && !value.endsWith("\"")) return false; //ERROR: BAD ATTRIBUTE FORMAT.
            }

            if (!tag.startsWith("/")) buffer.push(tag); // This is open tag
            else {  //This is closing tag
                if (buffer.isEmpty()) {
                    return false; //ERROR: NO OPEN TAG TO MATCH CLOSING TAG.
                }
                if (!tag.substring(1).equals(buffer.pop())) {
                    return false; //ERROR: OPEN TAG DOES NOT MATCH CLOSING TAG.
                }
            }
            open = s.indexOf('<', close+1);
        }
        return buffer.isEmpty(); //If the buffer is not empty a tag set was missing.
    }

    public static void main(String[] args) throws FileNotFoundException {
        //TO RUN FROM TERMINAL (SRC folder) USE: 'java au.edu.usc.XmlCheckerSolutionOne FILENAME'.

        String xmlString = new Scanner(new File("./tests/" + args[0])).useDelimiter("\\Z").next();
        System.out.println("\nFile " + args[0] + " is " + String.valueOf(checkXml(xmlString)).toUpperCase());

        //BULK FILE TESTING LOOP.
//        File tests = new File("src/tests/");
//        for(String file : tests.list()) {
//            String xmlString = new Scanner(new File("src/tests/" + file)).useDelimiter("\\Z").next();
//            System.out.println("File " + file + " is " + String.valueOf(checkTag(xmlString)).toUpperCase() + "\n");
//        }
    }
}