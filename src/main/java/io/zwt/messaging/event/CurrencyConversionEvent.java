package io.zwt.messaging.event;

import io.zwt.messaging.domain.CurrencyConversion;
import org.springframework.context.ApplicationEvent;

public class CurrencyConversionEvent extends ApplicationEvent {

    private static final long serialVersionUID = -4481493963350551884L;
    private CurrencyConversion conversion;
    private String message;


    public CurrencyConversionEvent(Object source, CurrencyConversion conversion) {
        super(source);
        this.conversion = conversion;
    }

    public CurrencyConversionEvent(Object source, String message, CurrencyConversion conversion) {
        super(source);
        this.message = message;
        this.conversion = conversion;
    }


    public CurrencyConversion getConversion() {
        return conversion;
    }

    public String getMessage() {
        return message;
    }
}
