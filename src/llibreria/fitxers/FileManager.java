/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package llibreria.fitxers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author cep
 */
public abstract class FileManager {
    private File file;
    private FileReader getFileReader() throws FileNotFoundException {
        return new FileReader(file);
    }
    private FileWriter getFileWriter() throws IOException {
        return new FileWriter(file);
    } 
    
    private FileManager(String file) {
        this.file = new File(file);
    }
    
    public File getFile() {
        return this.file;
    }
    public void setFile(String newFilePath) {
        this.file = new File(newFilePath);
    }
    public void setFile(File newFile) {
        this.file = newFile;
    }
    
    abstract public void start() throws FileNotFoundException, IOException;
    abstract public void close() throws IOException;
    
    public static class Reader extends FileManager {
        private BufferedReader reader;

        public Reader(String file) {
            super(file);
        }
        
        @Override
        public void start() throws FileNotFoundException {
            this.reader = new BufferedReader(super.getFileReader());
        }

        @Override
        public void close() throws IOException {
            this.reader.close();
        }
    }
    
    public static class Writer extends FileManager {
        private BufferedWriter reader;

        public Writer(String file) {
            super(file);
        }
        
        @Override
        public void start() throws FileNotFoundException, IOException {
            this.reader = new BufferedWriter(super.getFileWriter());
        }

        @Override
        public void close() throws IOException {
            this.reader.close();
        }
    }
}