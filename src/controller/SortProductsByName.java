package controller;

import model.Products;

import java.util.Comparator;

public class SortProductsByName implements Comparator<Products> {


    @Override
    public int compare(Products o1, Products o2) {
        return o1.getProductsName().compareTo(o2.getProductsName());
    }
}
