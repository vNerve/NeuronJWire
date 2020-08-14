package dd.center.vnerve.neuronwire;

/**
 * 标识 vNerve 产生的所有异常
 */
public class VNerveException extends Exception {
    public VNerveException() {
    }

    public VNerveException(String message) {
        super(message);
    }

    public VNerveException(String message, Throwable cause) {
        super(message, cause);
    }

    public VNerveException(Throwable cause) {
        super(cause);
    }

    public VNerveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
