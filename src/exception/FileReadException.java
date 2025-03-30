package exception;

public class FileReadException extends Exception{
    public FileReadException(String message){
        super(message);
    }
    public FileReadException(String message, Throwable e){
        super(message,e);
    }
}
