package hw3.ex;

public class FileWriteException extends Exception{
    public FileWriteException(String message){
        super(message);
    }
    public FileWriteException(String message, Throwable e){
        super(message,e);
    }
}
