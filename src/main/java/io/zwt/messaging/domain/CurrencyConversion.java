package io.zwt.messaging.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

	private String base;
	private String code;
	private float amount;
	private float total;

}