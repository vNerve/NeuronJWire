package dd.center.vnerve.neuronwire.deserialize;

import dd.center.vnerve.neuronwire.VNerveException;

/**
 * 在解析来自上游 vNerve 消息失败情况下抛出
 */
public class DeserializeFailedException extends VNerveException {
    public DeserializeFailedException() {
    }

    public DeserializeFailedException(String message) {
        super(message);
    }

    public DeserializeFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeserializeFailedException(Throwable cause) {
        super(cause);
    }

    public DeserializeFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
