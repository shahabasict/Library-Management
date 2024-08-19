package BookStoreManagement.Order_Service.exceptions;

public class InsufficientsStockException extends RuntimeException{

    public InsufficientsStockException(String message){
        super(message);
    }

}
