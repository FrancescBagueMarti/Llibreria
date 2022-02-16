/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package llibreria.fitxers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Francesc Bagué Martí
 */
public class MyFileManager {
    FileManager fm = new FileManager.Reader("pepe");
    
    private static final String WRITER = "writer";
    private static final String READER = "reader";
    private final File file;
    private BufferedReader reader = null;
    private FileWriter writer = null;
    
    public MyFileManager(String file_path) {
        this.file = new File(file_path);
    }
    
    public void startReader() 
            throws  FileNotFoundException, IOException {
        this.reader = new BufferedReader(new FileReader(this.file));
    }
    
    public void startWritter() 
            throws FileNotFoundException, IOException {
        this.writer = new FileWriter(file);
    }
    
    public void closeReader() 
            throws NullPointerException, IOException {
        if (checkNull(reader, READER)) {
            reader.close();
            reader = null;
        }
            
    }
    
    public void closeWriter() 
            throws NullPointerException, IOException {
        if (checkNull(writer, WRITER)) {
            writer.close();
            writer = null;
        }
    }
    
    public String readLine() 
            throws NullPointerException, FileNotFoundException, IOException {
        if (checkNull(reader, READER))
            return reader.readLine();
        else
            return null;
    }
    
    public ArrayList<String> readAll() 
            throws NullPointerException, FileNotFoundException, IOException {
        ArrayList<String> fileLines = new ArrayList<>();
        String curLine;
        
        if (checkNull(reader, READER)) {
            while ( (curLine = reader.readLine()) != null ) {
                fileLines.add(curLine);
            }
            return fileLines;
        } else
            return null;
    }
    
    public void writeLine(String line)
            throws NullPointerException, FileNotFoundException, IOException {
        if (checkNull(writer, WRITER))
                writer.write(line+"\n");
    }
    
    public void writeAll(List<String> lines)
            throws NullPointerException, FileNotFoundException, IOException {
        if (checkNull(writer, WRITER))
            for (String line : lines) {
                writer.write(line+"\n");
            }
    }
    
    public void writeAll(ArrayList<String> lines)
            throws NullPointerException, FileNotFoundException, IOException {
        if (checkNull(writer, WRITER))
            for (String line : lines) {
                writer.write(line+"\n");
            }
    }
    
    public void writeAll(String[] lines)
            throws NullPointerException, FileNotFoundException, IOException {
        if (checkNull(writer, WRITER))
            for (String line : lines) {
                writer.write(line+"\n");
            }
    }
    
    public void appendLine(String line) 
            throws NullPointerException, FileNotFoundException, IOException {
        if (checkNull(writer, WRITER)) 
            writer.append(line);
    }

    private boolean checkNull(Object o, String txt) 
            throws NullPointerException {
        if (o == null)
            throw new NullPointerException("The "+txt+" hasn't been started yet");
        else
            return true;
    }
}
