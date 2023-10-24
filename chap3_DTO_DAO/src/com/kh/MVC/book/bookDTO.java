package com.kh.MVC.book;

import java.util.Date;

public class bookDTO {
	private int book_id;
	private String title;
	private String author;
	private int Publication_year;
	private String isbn;
	private String genre;
	private String description;
	private double price;
	private Date publication_date;
	
	
	
	public bookDTO(int book_id, String title, String author,int publication_year, String isbn,String genre, String description, double price, Date publication_date) {
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.Publication_year = publication_year;
		this.isbn = isbn;
		this.genre = genre;
		this.description = description;
		this.price = price;
		this.publication_date = publication_date;
		

		
	}



	public int getBook_id() {
		return book_id;
	}



	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getPublication_year() {
		return Publication_year;
	}



	public void setPublication_year(int publication_year) {
		Publication_year = publication_year;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Date getPublication_date() {
		return publication_date;
	}



	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}
	
	
	
	
	
	

}
