package com.ilwllc.sgerke.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "date",
    "temp",
    "text"
})
public class Condition {
	
	@JsonProperty("code")
	public String code;
	
	@JsonProperty("date")
	public String date;
	
	@JsonProperty("temp")
	public String temp;
	
	@JsonProperty("text")
	public String text;
	
	public String getCode() {
		return code;
	}

	public void setItem(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
