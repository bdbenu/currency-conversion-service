package com.bd.benu.microservice.model;

import java.math.BigDecimal;

public class CurrencyConversionBean {
private Long id;
private String from;
private String to;
private BigDecimal convestionMultiple;
private BigDecimal quantity;
private BigDecimal totalCalculatedAmount;
private Long port;
public CurrencyConversionBean() {
	super();
}
public CurrencyConversionBean(Long id, String from, String to, BigDecimal convestionMultiple, BigDecimal quantity,
		BigDecimal totalCalculatedAmount, Long port) {
	super();
	this.id = id;
	this.from = from;
	this.to = to;
	this.convestionMultiple = convestionMultiple;
	this.quantity = quantity;
	this.totalCalculatedAmount = totalCalculatedAmount;
	this.port = port;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public BigDecimal getConvestionMultiple() {
	return convestionMultiple;
}
public void setConvestionMultiple(BigDecimal convestionMultiple) {
	this.convestionMultiple = convestionMultiple;
}
public BigDecimal getQuantity() {
	return quantity;
}
public void setQuantity(BigDecimal quantity) {
	this.quantity = quantity;
}
public BigDecimal getTotalCalculatedAmount() {
	return totalCalculatedAmount;
}
public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
	this.totalCalculatedAmount = totalCalculatedAmount;
}
public Long getPort() {
	return port;
}
public void setPort(Long port) {
	this.port = port;
}

}
