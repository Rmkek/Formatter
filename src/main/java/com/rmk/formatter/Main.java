package com.rmk.formatter;

import com.rmk.formatter.exception.WriterException;
import com.rmk.formatter.writer.FileWriter;

import java.io.*;

/**
 * Init class.
 */
final class Main {

    private static final int AMOUNT_OF_SPACES = 4;

    private Main() {
    }

    /**
     * Method for inserting spaces before line.
     *
     * @param amountOfCurlyBrackets amount of curly brackets that's already opened.
     * @param amountOfSpaces        amount of spaces that will be inserted before line.
     * @return string with amount of needed spaces before.
     */
    private static String insertSpaces(final int amountOfCurlyBrackets, final int amountOfSpaces) {
        int tmp = amountOfCurlyBrackets * amountOfSpaces;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < tmp; i++) {
            buffer.append(' ');
        }
        return buffer.toString();
    }

    /**
     * Main method for program.
     *
     * @param args arguments that will be passed into code.
     * @throws IOException thrown when any exception with reading/wirting occurs.
     */
    public static void main(final String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            StringBuilder builder = new StringBuilder();
            FileWriter writer = new FileWriter();
            writer.setWriter(new BufferedOutputStream(new FileOutputStream("output.txt")));

            int amountOfCurlyBrackets = 0;

            while (reader.ready()) {
                builder.append(reader.readLine());
                String tmp = builder.toString();

                if (tmp.contains("}")) {
                    builder.insert(tmp.indexOf("}") + 1, "\n");
                    amountOfCurlyBrackets--;
                }
                if (tmp.contains(")") && tmp.indexOf(")") == tmp.length() - 1) {
                    int idx = tmp.indexOf(')');
                    builder.insert(idx + 1, " {\n");
                    System.out.println(builder.toString());
                    amountOfCurlyBrackets++;
                    writer.write(builder.toString());
                    builder.delete(0, builder.length());
                    continue;
                }


                if (tmp.charAt(0) != ' ') {
                    builder.insert(0, insertSpaces(amountOfCurlyBrackets, AMOUNT_OF_SPACES));
                    tmp = builder.toString();
                } else if (tmp.indexOf("    ") != 0) {
                    for (int i = 0; i < AMOUNT_OF_SPACES; i++) {
                        if (tmp.charAt(i) != ' ') {
                            builder.insert(i, insertSpaces(amountOfCurlyBrackets, 2));
                            tmp = builder.toString();
                        }
                    }
                }

                if (tmp.charAt(tmp.length() - 1) == ';') {
                    builder.insert(builder.length(), "\n");
                    tmp = builder.toString();
                }


                if (tmp.contains("{")) {
                    builder.insert(tmp.indexOf("{") + 1, "\n");
                    amountOfCurlyBrackets++;
                }
                System.out.println(builder.toString());
                writer.write(builder.toString());
                builder.delete(0, builder.length());
            }
            writer.write("}");
            writer.close();

        } catch (IOException | WriterException ex) {
            throw new IOException("Exception when reading file.", ex);
        }
    }

}
