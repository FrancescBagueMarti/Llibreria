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
import java.util.ArrayList;

import llibreria.exceptions.FileManagerNotStartedException;

/**
 * this is a class for reading and writing of text files
 * @author Francesc Bagué Martí
 * @version 1.0
 * @since 2022/02/16
 */
public abstract class FileManager {
    private String filePath;
    private File file;
    
    private FileManager(String filepath) {
        this.filePath = filepath;
        this.file = new File(filePath);
    }
    /**
     * @return Returns a FileReader
     * @throws FileNotFoundException Throws a FileNotFoundException
     */
    private FileReader getFileReader() throws FileNotFoundException {
        return new FileReader(file);
    }
    /**
     * @return Returns a FileWriter
     * @throws IOException Throws an IOException
     */
    private FileWriter getFileWriter() throws IOException {
        return new FileWriter(file);
    }
    
    /**
     * @return Returns a File
     */
    public File getFile() {
        return this.file;
    }
    /**
     * @return Returns a String
     */
    public String getFilePath() {
        return filePath;
    }
    /**
     * @param newFilePath New file path
     */
    public void setFile(String newFilePath) {
        this.filePath = newFilePath;
        this.file = new File(newFilePath);
    }
    /**
     * @param newFile New File object
     */
    public void setFile(File newFile) {
        this.filePath = newFile.getPath();
        this.file = newFile;
    }
    
    /**
     * Method that starts the Reader / Writer
     * @throws FileNotFoundException Throws a FileNotFoundException
     * @throws IOException Throws an IOException
     */
    abstract public void start() throws FileNotFoundException, IOException;
    /**
     * Method that closes the Reader / Writer
     * @throws IOException Throws an IOException
     */
    abstract public void close() throws IOException;
    
    /**
     * Class for the reading of text files
     */
    public static class Reader extends FileManager {
        private BufferedReader reader;
        private boolean hasBeenStarted = false;

        /**
         * Constructor for the Reader
         * @param file The file's path
         */
        public Reader(String file) {
            super(file);
        }
        
        @Override
        public void start() throws FileNotFoundException {
            this.reader = new BufferedReader(super.getFileReader());
            this.hasBeenStarted = true;
        }
        @Override
        public void close() throws IOException {
            this.reader.close();
            this.hasBeenStarted = false;
        }
        
        /**
         * Method that reads a single line from a text file
         * @return Returns a String object
         * @throws FileManagerNotStartedException Throws a custom Exception {@link llibreria.exceptions.FileManagerNotStartedException}
         */
        public String readLine() throws FileManagerNotStartedException {
            if (this.hasBeenStarted)
                try {
                    return this.reader.readLine();
                } catch (IOException ex) {
                    throw new FileManagerNotStartedException(ex);
                }
            else 
                throw new FileManagerNotStartedException();
        }
        /**
         * Method that reads all the text inside a file and returns it inside an ArrayList
         * @return Returns an ArrayList object
         * @throws FileManagerNotStartedException Throws a custom Exception {@link llibreria.exceptions.FileManagerNotStartedException}
         */
        public ArrayList<String> readAll() throws FileManagerNotStartedException {
            if (this.hasBeenStarted) {
                ArrayList<String> content = new ArrayList<>();
                String line;
                try {
                    while ( (line = this.reader.readLine()) != null ) {
                        content.add(line);
                    }
                    return content;
                } catch (IOException ex) {
                    throw new FileManagerNotStartedException(ex);
                }
            } else 
                throw new FileManagerNotStartedException();
                
        }

    }
    
    /**
     * Class for the writing of text files
     */
    public static class Writer extends FileManager {
        private BufferedWriter writer;
        private boolean hasBeenStarted = false;

        /**
         * Constructor for the Writer
         * @param file The file's path
         */
        public Writer(String file) {
            super(file);
        }
        
        @Override
        public void start() throws FileNotFoundException, IOException {
            this.writer = new BufferedWriter(super.getFileWriter());
            this.hasBeenStarted = true;
        }

        @Override
        public void close() throws IOException {
            this.writer.close();
            this.hasBeenStarted = false;
        }
        
        /**
         * Method that writes a single line in a text file
         * @param line Line that will be written
         * @throws FileManagerNotStartedException Throws a custom Exception {@link llibreria.exceptions.FileManagerNotStartedException}
         */
        public void writeLine(String line) throws FileManagerNotStartedException {
            if (this.hasBeenStarted)
                try {
                    this.writer.write(line);
                } catch (IOException ex) {
                    throw new FileManagerNotStartedException(ex);
                }
            else 
                throw new FileManagerNotStartedException();
        }
        /**
         * Method that writes a whole text file
         * @param lines Array with all the lines that will be written in the file
         * @throws FileManagerNotStartedException Throws a custom Exception {@link llibreria.exceptions.FileManagerNotStartedException}
         */
        public void writeAll(String[] lines) throws FileManagerNotStartedException {
            if (this.hasBeenStarted) {
                try {
                    for (String line : lines)
                        this.writer.write(line);
                } catch (IOException ex) {
                    throw new FileManagerNotStartedException(ex);
                }
                        
            } else 
                throw new FileManagerNotStartedException();
        }
        /**
         * Method that writes a whole text file
         * @param lines List with all the lines that will be written in the file
         * @throws FileManagerNotStartedException Throws a custom Exception {@link llibreria.exceptions.FileManagerNotStartedException}
         */
        public void writeAll(ArrayList<String> lines) throws FileManagerNotStartedException {
            if (this.hasBeenStarted) {
                try {
                    for (String line : lines)
                        this.writer.write(line);
                } catch (IOException ex) {
                    throw new FileManagerNotStartedException(ex);
                }
                        
            } else 
                throw new FileManagerNotStartedException();
        }
    }
}