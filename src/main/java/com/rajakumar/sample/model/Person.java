package com.rajakumar.sample.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private final UUID uuid;
	private final String name;
	
	public Person(@JsonProperty("id") UUID uuid, 
				  @JsonProperty("name") String name) {
		super();
		this.uuid = uuid;
		this.name = name;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}
	public String toString() {
		return ""+this.uuid+"||"+this.name;
	}
}
