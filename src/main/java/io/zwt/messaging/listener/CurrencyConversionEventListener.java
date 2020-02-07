package io.zwt.messaging.listener;

import io.zwt.messaging.event.CurrencyConversionEvent;
import lombok.extern.log4j.Log4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j
public class CurrencyConversionEventListener {

//    private static final Logger log = LoggerFactory.getLogger(CurrencyConversionEventListener.class);

    private static final String DASH_LINE = "========================================================";
    private static final String NEXT_LINE = "\n";


    @EventListener
    public void onApplicationEvent(CurrencyConversionEvent event) {
        Object obj = event.getSource();
        StringBuilder str = new StringBuilder(NEXT_LINE);
        str.append(DASH_LINE);
        str.append(NEXT_LINE);
        str.append("  Class: " + obj.getClass().getSimpleName());
        str.append(NEXT_LINE);
        str.append("Message: " + event.getMessage());
        str.append(NEXT_LINE);
        str.append("  Value: " + event.getConversion());
        str.append(NEXT_LINE);
        str.append(DASH_LINE);
        log.error(str.toString());
    }
}
