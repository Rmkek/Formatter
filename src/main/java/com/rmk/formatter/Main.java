package com.rmk.formatter;

import com.rmk.formatter.formatter.Formatter;
import com.rmk.formatter.reader.FileReader;
import com.rmk.formatter.writer.FileWriter;

/**
 * Init class.
 */
final class Main {

    private Main() {}

    /**
     * Main method.
     * @param args arguments that will be passed in runtime.
     * @throws Exception when any exception happens - throw it into runtime.
     */
    public static void main(final String[] args) throws Exception {
        Formatter formatter = new Formatter();

        System.out.println(System.getProperty("user.dir"));
        FileReader reader = new FileReader("input.txt");
        FileWriter writer = new FileWriter("output.txt", "UTF-8");

        try {
            formatter.format(reader, writer);
        } catch (Exception ex) {
            throw new Exception("Exception happened.", ex);
        }
    }
}
