package es.ulpgc.eite.cleancode.catalog.data;

import java.util.ArrayList;
import java.util.List;


public class CatalogRepository implements RepositoryContract {

  private static CatalogRepository INSTANCE;

  private final List<ProductItem> itemList = new ArrayList<>();
  private final int COUNT = 20;

  public static RepositoryContract getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new CatalogRepository();
    }

    return INSTANCE;
  }


  private CatalogRepository() {
    // Add some sample items.
    for (int index = 1; index <= COUNT; index++) {
      addProduct(createProduct(index));
    }
  }

  @Override
  public ProductItem getProduct(int id) {
    for (ProductItem item : itemList) {
      if (item.id == id) {
        return item;
      }
    }

    return null;
  }

  @Override
  public List<ProductItem> getProductList() {
    return itemList;
  }

  private void addProduct(ProductItem item) {
    itemList.add(item);
  }


  private ProductItem createProduct(int position) {
    String content = "Product " + position;

    return new ProductItem(
        position, content, fetchProductDetails(position)
    );

  }


  private String fetchProductDetails(int position) {
    String content = "Details about Product:  " + position;
    StringBuilder builder = new StringBuilder();
    builder.append(content);

    for (int index = 0; index < position; index++) {
      builder.append("\nMore details information here.");
    }

    return builder.toString();
  }

}
