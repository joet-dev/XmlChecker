//package au.edu.usc;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
//public class Two {
//
//    public static String xmlString;
//
//    public static boolean checkXml(String s) {
//        int open = xmlString.indexOf('<');
//        if(open == -1) return false;
//        int close = xmlString.indexOf('>', open + 1);
//        if (close == -1) return false;
//
//        Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(xmlString.substring(open + 1, close).split(" ")));
//        String tag = tagContentQ.remove();
//
//        Node<String> root = new Node<String>(tag);
//        recurTree(root, 0);
//        return true;
//    }
//
//    public static boolean recurTree(Node<String> parent, int start) {
//        int open = xmlString.indexOf('<', start);
//        if(open == -1) return false;
//        int close = xmlString.indexOf('>', open + 1);
//        if (close == -1) return false;
//
//        Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(xmlString.substring(open + 1, close).split(" ")));
//        String tag = tagContentQ.remove();
//
//        while(!tagContentQ.isEmpty()) {
//            String att = tagContentQ.remove();
//            String value = att.substring(att.indexOf("=") + 1);
//            if(!value.startsWith("\"") && !value.endsWith("\"")) return false;
//        }
//
//        if (!tag.startsWith("/")) {
//            Node<String> node = new Node<String>(tag);
//            parent.addChild(node);
//            System.out.println("RECUR: " + node);
//            return recurTree(node, close+1);
//        } else {
//            System.out.println("Test " + parent + tag);
//            if (parent.getParent() == null) return false;
//            return tag.substring(1).equals(parent.getData());
//        }
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        //TO RUN FROM TERMINAL USE: 'java au.edu.usc.One FILENAME'.
////        String xmlString = new Scanner(new File("./tests/" + args[0])).useDelimiter("\\Z").next();
////        System.out.println("File " + args[0] + " is " + String.valueOf(checkTag(xmlString)).toUpperCase() + "\n");
//
//        //BULK FILE TESTING LOOP.
//        File file = new File("False_2.xml");
////        for(String file : tests.list()) {
//        xmlString = new Scanner(new File("src/tests/" + file)).useDelimiter("\\Z").next();
//        System.out.println("File " + file + " is " + String.valueOf(checkXml(xmlString)).toUpperCase() + "\n");
////        }
//    }
//
//}
//
////    public static Queue<String> tagLookup(int start) {
////        int open = xmlString.indexOf('<', start);
////        if(open == -1) return new LinkedList<String>();
////        int close = xmlString.indexOf('>', open + 1);
////        if (close == -1) return new LinkedList<String>();
////
////        Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(xmlString.substring(open + 1, close).split(" ")));
////
////        return tagContentQ;
////    }
//
//
//    public static boolean checkXml() {
//        int open = xmlString.indexOf('<');
//        if(open == -1) return false;
//        int close = xmlString.indexOf('>', open + 1);
//        if (close == -1) return false;
//
//        Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(xmlString.substring(open + 1, close).split(" ")));
//        String tag = tagContentQ.remove();
//
//        Node<String> root = new Node<String>(tag);
//
//        boolean rootValid = true; //Used to check whether the xml has only one root tag.
//        while(open != -1) { //Checks whether open bracket was found
//            open = xmlString.indexOf('<', close+1);
//            close = xmlString.indexOf('>', open+1);
//
//            if(close == -1) return false; //ERROR: TAG SYNTAX.
//            else if(!rootValid && ) return false; //ERROR: MULTIPLE ROOT TAGS FOUND.
//            else rootValid = false; //Lets the
//
//            Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(xmlString.substring(open + 1, close).split(" ")));
//            String tag = tagContentQ.remove();
//
//            while(!tagContentQ.isEmpty()) {
//                String att = tagContentQ.remove();
//                String value = att.substring(att.indexOf("=") + 1);
//                if(!value.startsWith("\"") && !value.endsWith("\"")) return false; //ERROR: BAD ATTRIBUTE FORMAT.
//            }
//
//            if (!tag.startsWith("/")) buffer.push(tag); // This is open tag
//            else {  //This is closing tag
//                if (buffer.isEmpty()) {
//                    return false; //ERROR: NO OPEN TAG TO MATCH CLOSING TAG.
//                }
//                if (!tag.substring(1).equals(buffer.pop())) {
//                    return false; //ERROR: OPEN TAG DOES NOT MATCH CLOSING TAG.
//                }
//            }
//        }
//        return true;
//    }