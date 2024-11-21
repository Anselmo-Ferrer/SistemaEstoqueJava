package Excepetions;

public class EstoqueVazio extends RuntimeException {
    public EstoqueVazio(String message) {
        super(message);
    }
}
