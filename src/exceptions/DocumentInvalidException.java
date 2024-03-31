package exceptions;

public class DocumentInvalidException extends PersonException{
    public DocumentInvalidException(int document) {
        super("Documento inválido! "+document);
    }
}
