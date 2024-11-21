package Excepetions;

public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado(String message) {
        super(message);
    }
}
