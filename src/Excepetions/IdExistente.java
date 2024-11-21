package Excepetions;

public class IdExistente extends RuntimeException {
    public IdExistente(String message) {
        super(message);
    }
}
