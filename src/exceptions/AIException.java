package exceptions;

public class AIException extends Exception{
    private String num;
    public AIException(String id){
        super("Unexistent Account");
        num = id;
    }

    public String getId(){
        return num;
    }
}
