package exceptions;

public class CRFInvalidException extends Exception{
    public CRFInvalidException(int CRF){
        super("CRF inválido! "+CRF);
    }
}
