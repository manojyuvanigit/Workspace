package org.example.OnlySpring;

import java.util.ArrayList;
import java.util.List;

public class BookShop {
    public String name;
    public List<Book> books = new ArrayList<Book>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void loadData(){
        for(int i=0;i<10;i++){
            Book b = new Book();
            b.setTitle("Book " + i);
            b.setAuthor("Author " + i);
            b.setPrice("$" + (10 + i));
            books.add(b);
        }
    }

    public BookShop clone(){
        BookShop shop = new BookShop();
        for(Book b : this.books){
            Book b1 = new Book();
            b1.setTitle(b.getTitle());
            b1.setAuthor(b.getAuthor());
            b1.setPrice(b.getPrice());
            shop.books.add(b1);
        }
        return shop;
    }
    public void printBook(){
        System.out.println("Book Shop Name: " + name);
        for(Book b : books){
            System.out.println("Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", Price: " + b.getPrice());
        }
    }
}
