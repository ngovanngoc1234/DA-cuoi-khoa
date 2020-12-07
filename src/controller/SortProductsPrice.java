package controller;

import model.Products;

import java.util.Comparator;

public class SortProductsPrice implements Comparator<Products> {


    @Override
    public int compare(Products o1, Products o2) {
        return (o1.getPrice() > o2.getPrice()) ? 1 : 0;
    }
}
