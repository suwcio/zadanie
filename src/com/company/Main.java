package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List products = new ArrayList();
        products.add(new Product("A", "CAT1", 100));
        products.add(new Product("B", "CAT1", 200));
        products.add(new Product("C", "CAT2", 20));
        products.add(new Product("D", "CAT2", 30));

        groupByCategoryAveragePrice(products);
    }

    /**
     * This method returns List of Nodes, each node contains info about category
     * of the product and it's average price for example: You have list of
     * products (name, category, price) [(A, CAT1, 100), (B, CAT1, 200), (C,
     * CAT2, 20), (D, CAT2, 30)] then the result will be: [(CAT2, 25),(CAT1,
     * 150)] note that: result should be ordered by average price ASC.
     *
     * @param products
     *            list of products, cannot be null
     * @return ordered result list
     */

    public static List<Node> groupByCategoryAveragePrice(List<Product> products) {
        Map<String, Double> helper = new HashMap<>();

        for (Product product : products){
            if (!helper.containsKey(product.getCategory())){
                helper.put(product.getCategory(), (double) product.getPrice());
            } else {
                helper.put(product.getCategory(), helper.get(product.getCategory()) + product.getPrice());
            }
        }

        List<Node> nodes = new ArrayList<>();
        Iterator iterator = helper.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry node = (Map.Entry) iterator.next();
            nodes.add(new Node((String) node.getKey(), (Double) node.getValue()));
        }

        return nodes;
    }
}
