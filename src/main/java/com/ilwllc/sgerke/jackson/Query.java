package com.ilwllc.sgerke.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "created",
    "lang",
    "results"
})
public class Query {
	
	@JsonProperty("count")
	public String Count;

	@JsonProperty("created")
	public String Created;

	@JsonProperty("lang")
	public String Language;

	@JsonProperty("results")
	public Results results;
	
	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		this.Count = count;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		this.Created = created;
	}
	
	public String getLang() {
		return Language;
	}

	public void setLang(String lang) {
		this.Language = lang;
	}
	
	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

}
