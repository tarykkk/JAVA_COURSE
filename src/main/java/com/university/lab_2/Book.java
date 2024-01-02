package com.university.lab_2;

public class Book extends Item{
    private String _author;
    public Book(String title, String uniqueId, String author){
        super(title, uniqueId);
        this._author = author;
    }
    public String get_author(){
        return _author;
    }
    @Override
    public void borrowItem(){
        setIsBorrowed(true);
    }
    @Override
    public void returnItem(){
        setIsBorrowed(false);
    }
}
