package ru.netology;

public class ProductManager {
    private ProductRepository repo;

    public ProductRepository getRepo() {
        return repo;
    }

    public void setRepo(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }


    public void add(Product prod) {
        repo.save(prod);
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Smartphone чтобы пользоваться методами класса Smartphone
            if (smartphone.getManufacturer().contains(search)) { // проверим есть ли поисковое слово в данных о производителе
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
        }
        return false;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);   // можно так вместо for
//                for (int i = 0; i < result.length; i++) {
//                    tmp[tmp.length - 1] = product;
//                    result = tmp;
//                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}


