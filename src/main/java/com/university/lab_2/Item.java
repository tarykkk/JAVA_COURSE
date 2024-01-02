package com.university.lab_2;

public abstract class Item {
    private String _title;
    private String _uniqueId;
    private boolean _isBorrowed;
    public Item(String title, String uniqueId){
        this._title = title;
        this._uniqueId = uniqueId;
        this._isBorrowed = false;
    }
    public String get_title(){
        return _title;
    }
    public String get_uniqueId(){
        return _uniqueId;
    }
    public boolean getIsBorrowed(){
        return _isBorrowed;
    }
    public void setIsBorrowed(boolean borrowed){
        _isBorrowed = borrowed;
    }

    public abstract void borrowItem();
    public abstract void returnItem();

}
