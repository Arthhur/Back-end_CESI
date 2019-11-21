package fr.cesi.commerce.model;

public class UnknownProductException extends Exception{
	public UnknownProductException(Long id) {
		super("The product with id=" + id + " doesn't exist.");
	}
}
