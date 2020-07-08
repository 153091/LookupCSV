/**
 * %java LookupCSV.java amino.csv 0 3
 * ACT
 *   Threonine
 * TAG
 *   Stop
 * CAT
 *   Histidine
 *   */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Map;
import java.util.TreeMap;

/**
 * Command-line arguments.
 * ・A comma-separated value (CSV) file.
 * ・Key field.
 * ・Value field.
 * */

public class LookupCSV {

    public static void main(String[] args) {

        // process input file
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]); // какое значение (tokens[]) в строчке будет ключом
        int valueField = Integer.parseInt(args[2]); // какое значение (tokens[]) в строке будет значением

        // build symbol table
        Map<String, String> st = new TreeMap<>(); // RB BST
        while (!in.isEmpty()) {
            String line = in.readLine(); // считываем строку
            String[] tokens = line.split(","); // разделяем строку на отдельные значения (tokens[])
            st.put(tokens[keyField], tokens[valueField]);
        }

        // process lookups with standard I/O
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (st.containsKey(s)) StdOut.println(st.get(s));
            else                   StdOut.println("Not found");
        }

    }
}
