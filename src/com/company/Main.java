package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List products = new ArrayList();
        products.add(new Product("A", "CAT1", 100));
        products.add(new Product("B", "CAT1", 200));
        products.add(new Product("C", "CAT2", 20));
        products.add(new Product("D", "CAT2", 30));

        List<Node> nodes = groupByCategoryAveragePrice(products);

        nodes.forEach(node -> System.out.println(node.getName() + " -> " + node.getAverage()));
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
        return products.stream()
            .collect(Collectors.groupingBy(Product::getCategory))
            .entrySet()
            .stream()
            .map(item -> new Node(item.getKey(), calcAveragePrice(item.getValue())))
            .sorted(Comparator.comparingDouble(Node::getAverage))
            .collect(Collectors.toList());
    }

    private static double calcAveragePrice(List<Product> products) {
        return products.stream()
                .mapToInt(Product::getPrice)
                .average()
                .orElse(-1);
    }
}
