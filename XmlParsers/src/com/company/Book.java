package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel_Haidzinski on 8/24/2017.
 */
public class Book {

    String title;
    List<String> author;
    String year;
    String price;

    public Book(){
        this.author = new ArrayList<String>();
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setAuthor(String author_value){
        author.add(author_value);
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getYear(){
        return this.year;
    }

    public void setPrice (String price){
        this.price = price;
    }

    public String getPrice(){
        return this.price;
    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();
        builder.append("\r\nAuthors: \r\n");
        for(String auth: author){
            builder.append(auth + "\r\n");
        }

        String finalAuthors = builder.toString();

        return "Title: " + this.title + "\r\n " + "Year: " + this.year + finalAuthors + "Price:" + this.price + "\r\n";
    }

}
