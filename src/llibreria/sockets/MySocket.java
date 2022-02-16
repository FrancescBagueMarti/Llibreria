/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package llibreria.sockets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class with various methods oriented to the usage of {@link java.net.Socket}, 
 * and for the sending and receiving of objects.
 * @author Francesc Bague Marti
 * @version 1.0 2022/02/02
 */
public class MySocket {
    private String ip;
    private int port;
    private ServerSocket serverSocket;
    private Socket socket;
    private boolean isClient;
    
    /**
     * Empty constructor
     */
    public MySocket(){
        
    }
    /**
     * Constructor for a client socket
     * @param ip String with the server's IP address
     * @param port Integer with the server's PORT
     */
    public MySocket(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.isClient = true;
    }
    /**
     * Constructor for a server's socket
     * @param serverSocket ServerSocket object that will be used for the connection
     * @throws IOException Throws an Exception
     */
    public MySocket(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
        this.isClient = false;
    }
    /**
     * Method that starts the client's socket connection
     * @throws IOException Throws an Exception
     */
    public void start() throws IOException {
        if (isClient)
            this.socket = new Socket(ip, port);
        else
            throw new IOException("Este mètodo solo funciona si el socket es de un cliente");
    }
    /**
     * Method that makes the server's socket accept a new client connection
     * @throws IOException Throws an Exception
     */
    public void accept() throws IOException {
        if (isClient)
            throw new IOException("Este mètodo solo funciona si el socket es un servidor.");
        else
            this.socket = serverSocket.accept();
    }
    /**
     * Method that returns the client's IP address
     * @return Returns a String object
     */
    public String getIP() {
        return this.socket.getInetAddress().getHostName();
    }
    /**
     * Method for the sending of an object between the server and the client
     * @param object Object that will be sent
     * @throws IOException Throws an exception
     */
    public void send(Object object) throws IOException {
        OutputStream os = this.socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(object);
    }
    /**
     * Mehod for the sending of an <b>object array</b> between the server and the client
     * @param objects Object array that will be sent
     * @throws IOException  Throws an exception
     */
    public void send(Object[] objects) throws IOException {
        OutputStream os = this.socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject((Object) objects);
    }
    /**
     * Mehod for the sending of an <b>String array</b> between the server and the client
     * @param lines String array that will be sent
     * @throws IOException  Throws an exception
     */
    public void send(String[] lines) throws IOException {
        OutputStream os = this.socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject((Serializable) lines);
    }
    /**
     * Method that reads an object
     * @return Returns an object
     * @throws IOException Throws an exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public Object readObject() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return ois.readObject();
    }
    /**
     * Mehod that reads an <b>object array</b>
     * @return Returns an object array
     * @throws IOException Throws an exception
     * @throws ClassNotFoundException Throws an exception
     */
    public Object[] readObjects() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (Object[]) ois.readObject();
    }
    /**
     * Method that reads an <b>object array</b>
     * @return Returns an object array
     * @throws IOException Throws an exception
     * @throws ClassNotFoundException Throws an exception
     * @deprecated This method is deprecated, use {@link client.MySocket#readObjects() } instead
     */
    @Deprecated
    public Object[] readObject_Array() throws IOException, ClassNotFoundException {
        ObjectInputStream ois;
        
        int size = new ObjectInputStream(this.socket.getInputStream()).readInt();
        
        Object[] objects = new Object[size];
        for (int i = 0; i < size; i++) {
            ois = new ObjectInputStream(this.socket.getInputStream());
            objects[i] = ois.readObject();
        }
        
        return objects;
    }
    /**
     * Method that reads a String
     * @return Returns a String object
     * @throws IOException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public String readString() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (String) ois.readObject();
    }
    /**
     * Method that reads a char
     * @return Returns a char object
     * @throws IOException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public char readChar() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (char) ois.readObject();
    }
    /**
     * Method that reads an int
     * @return Returns an int object
     * @throws IOException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public int readInt() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (int) ois.readObject();
    }
    /**
     * Method that reads a double
     * @return returns a double object
     * @throws IOException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public double readDouble() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (double) ois.readObject();
    }
    /**
     * Method that reads a float
     * @return Returns a float object
     * @throws IOException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public float readFloat() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (float) ois.readObject();
    }
    /**
     * Method that reads a long
     * @return Returns a long object
     * @throws IOException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public long readLong() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (long) ois.readObject();
    }
    /**
     * Method that reads a short
     * @return Returns a short object
     * @throws IOException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public short readShort() throws IOException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (short) ois.readObject();
    }
    /**
     * Method that reads a byte
     * @return Returns a byte object
     * @throws IOException Throws an Exception
     * @throws ClassCastException Throws an Exception
     * @throws ClassNotFoundException Throws an Exception
     */
    public float readByte() throws IOException, ClassCastException, ClassNotFoundException {
        InputStream is = this.socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (byte) ois.readObject();
    }
    /**
     * Method that closes the socket's connection
     * @throws IOException Throws an Exception
     */
    public void close() throws IOException {
        if (isClient) {
            this.socket.close();
        } else {
            this.socket.close();
            this.serverSocket.close();
        }
    }
}
