package com.inventoryservice.app.kafka;

public enum KafkaTopic {
	createcar("createcar"), updatecar("updatecar"), deletecar("deletecar"), updatebrand("updatebrand"), updatemodel("updatemodel");
	
	String topicname;
	
	KafkaTopic(String name) {
		this.topicname = name;
	}
	
	public String getName() {
		return this.topicname;
	}
}
