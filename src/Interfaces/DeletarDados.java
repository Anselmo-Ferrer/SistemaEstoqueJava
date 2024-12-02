package Interfaces;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public interface DeletarDados {
    void removerDados() throws IOException, CsvValidationException;;
}