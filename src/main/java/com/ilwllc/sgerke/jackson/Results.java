package com.ilwllc.sgerke.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channel"
})
public class Results {
	
	@JsonProperty("channel")
	public Channel channel1;
	
	public Channel getChannel() {
		return channel1;
	}

	public void setChannel(Channel channel) {
		this.channel1 = channel;
	}

}
