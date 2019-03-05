package es.ulpgc.eite.cleancode.catalog.data;

import java.util.List;

public interface RepositoryContract {

  List<ProductItem> getProductList();

  ProductItem getProduct(int id);
}
