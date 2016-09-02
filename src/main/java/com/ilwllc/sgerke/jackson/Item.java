package com.ilwllc.sgerke.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channel"
})
public class Item {
	
	@JsonProperty("condition")
	public Condition condition;
	
	public Condition getCondition() {
		return condition;
	}

	public void setItem(Condition condition) {
		this.condition = condition;
	}

}
