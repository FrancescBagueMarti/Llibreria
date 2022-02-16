/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package llibreria.exceptions.filemanagerexceprions;

/**
 * Custom Exception that will only be thrown whenever the program tries to use 
 * a FileManager Reader/Writer without it having been initialized first
 * @author Francesc Bagué Martí
 * @version 1.0
 * @since 2022/02/16
 */
public class FileManagerNotStartedException extends Exception {
    /**
     * Constructor for the Exception
     */
    public FileManagerNotStartedException() {
        super("The FileManager Object has not been started");
    }
    /**
     * Constructor for the Exception
     * @param cause {@link java.lang.Throwable} object with the root cause of the exception
     */
    public FileManagerNotStartedException(Throwable cause) {
        super("The FileManager Object has not been started", cause);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
