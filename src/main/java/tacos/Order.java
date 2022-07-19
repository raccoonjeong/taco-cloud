package tacos;

import lombok.Data;

@Data
public class Order {
	public String deliveryName, deliveryStreet, deliveryCity, 
	deliveryState, deliveryZip, ccNumber, ccExpiration, ccCVV;
}
