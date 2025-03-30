package exception;

public class FileWriteException extends Exception{
    public FileWriteException(String message){
        super(message);
    }
    public FileWriteException(String message, Throwable e){
        super(message,e);
    }
}
