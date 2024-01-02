package com.university.lab_2;

public class DVD extends Item{
    private int _duration;
    public DVD(String title, String uniqueId, int duration){
        super(title, uniqueId);
        this._duration = duration;
    }
    public int get_duration(){
        return _duration;
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
