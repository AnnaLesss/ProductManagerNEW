package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository Repository = new ProductRepository();
    ProductManager Manager = new ProductManager(Repository);

    Product Smartphone = new Smartphone(22222, "Apple", 100_000, "США");
    Product Book = new Book(12345, "Мастер и Маргарита", 600, "Булгаков");
    Product Book2 = new Book (555, "Война и мир", 500, "Толстой");
    Product Smartphone2 = new Smartphone (1023, "Samsung", 97_000, "Южная Корея");

    @BeforeEach
    public void Product() {

        Manager.add(Smartphone);
        Manager.add(Book);
        Manager.add(Book2);
        Manager.add(Smartphone2);

    }

    @Test

    public void shouldFindAuthor () {


            Product[] expected = {Book};
            Product[] actual = Manager.searchBy("Булгаков");
            assertArrayEquals(expected, actual);
        }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {Book2};
        Product[] actual = Manager.searchBy("Война и мир");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {Book2};
        Product[] actual = Manager.searchBy("Толстой");
        assertArrayEquals(expected, actual);
    }


}
