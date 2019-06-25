package exceptions.dto;

public class WrongDataException extends Throwable {
    public WrongDataException(String msg){
        super(msg);
    }
}
