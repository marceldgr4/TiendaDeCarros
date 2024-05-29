package CarStore.BookingService.Exceptions;

public class CarReserveException extends RuntimeException{
    public CarReserveException(){
        super();

    }
    public CarReserveException(String Messager){
        super(Messager);
    }
    public CarReserveException(String Messager, Throwable cause){
        super(Messager,cause);
    }
    public CarReserveException(Throwable cause){
        super(cause);
    }
    public CarReserveException(String Messeger,Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(Messeger,cause,enableSuppression,writableStackTrace);
    }
}
