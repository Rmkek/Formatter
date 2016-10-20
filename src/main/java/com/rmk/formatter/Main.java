package com.rmk.formatter;

import com.rmk.formatter.exception.WriterException;
import com.rmk.formatter.writer.FileWriter;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            System.out.println(System.getProperty("user.dir"));
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            StringBuilder builder = new StringBuilder();
            FileWriter writer = new FileWriter();
            writer.setWriter(new BufferedOutputStream(new FileOutputStream("output.txt")));


            while (reader.ready()) {
                builder.append(reader.readLine());
                String tmp = builder.toString();

                if (tmp.contains(")") && tmp.indexOf(")") == tmp.length() - 1) {
                    int idx = tmp.indexOf(')');
                    builder.insert(idx + 1, " {\n");
                    System.out.println(builder.toString());
                    writer.write(builder.toString());
                    builder.delete(0, builder.length());
                    continue;
                }

                if(tmp.charAt(0) != ' '){
                    builder.insert(0, "    ");
                } else if(tmp.indexOf("    ") != 0) {
                    for (int i = 0; i < 4; i++) {

                        if(tmp.charAt(0) != ' ') {
                            builder.insert(i, ' ');
                        }
                    }
                }

                System.out.println(builder.toString());
                writer.write(builder.toString());
                builder.delete(0, builder.length());
            }
            writer.write("\n}");
            writer.close();

        } catch (IOException | WriterException ex) {
            throw new IOException("Exception when reading file.", ex);
        }
    }

}
