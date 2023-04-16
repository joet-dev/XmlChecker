package au.edu.usc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class XmlCheckerSolutionTwo {

    public static String xmlString;

    public static boolean checkXml() {
        int open = xmlString.indexOf('<');
        if(open == -1) return false;
        int close = xmlString.indexOf('>', open + 1);
        if (close == -1) return false;

        Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(xmlString.substring(open + 1, close).split(" ")));
        String tag = tagContentQ.remove();

        Node<String> root = new Node<String>(tag);
        recurTree(root, 0);
        return true;
    }

    public static boolean recurTree(Node<String> parent, int start) {
        int open = xmlString.indexOf('<', start);
        if(open == -1) return false;
        int close = xmlString.indexOf('>', open + 1);
        if (close == -1) return false;

        Queue<String> tagContentQ = new LinkedList<String>(Arrays.asList(xmlString.substring(open + 1, close).split(" ")));
        String tag = tagContentQ.remove();

        while(!tagContentQ.isEmpty()) {
            String att = tagContentQ.remove();
            String value = att.substring(att.indexOf("=") + 1);
            if(!value.startsWith("\"") && !value.endsWith("\"")) return false;
        }

        if (!tag.startsWith("/")) {
            Node<String> node = new Node<String>(tag);
            parent.addChild(node);
            System.out.println("RECUR: " + node);
            return recurTree(node, close+1);
        } else {
            System.out.println("Test " + parent + tag);
            if (parent.getParent() == null) return false;
            return tag.substring(1).equals(parent.getData());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //TO RUN FROM TERMINAL USE: 'java au.edu.usc.XmlCheckerSolutionTwo FILENAME'.
        xmlString = new Scanner(new File("./tests/" + args[0])).useDelimiter("\\Z").next();
        System.out.println("File " + args[0] + " is " + String.valueOf(checkXml()).toUpperCase() + "\n");
    }
}
