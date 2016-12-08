package com.rmk.formatter;

import com.rmk.formatter.formatter.Formatter;
import com.rmk.formatter.formatter.StateManager;
import com.rmk.formatter.reader.IReader;
import com.rmk.formatter.reader.ReaderFactory;
import com.rmk.formatter.writer.IWriter;
import com.rmk.formatter.writer.WriterFactory;

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

        System.out.println("You have to write input file and output file (try input.txt and output.txt).");

        IReader reader = ReaderFactory.getReader("FileReader, input.txt");
        IWriter writer = WriterFactory.getWriter("FileWriter, output.txt");

        try {
            formatter.format(reader, writer, new StateManager());

        } catch (Exception ex) {
            throw new Exception("Exception happened.", ex);
        }
    }
}
