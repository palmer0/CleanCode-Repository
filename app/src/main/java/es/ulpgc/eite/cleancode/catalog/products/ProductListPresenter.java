package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.data.ProductItem;


public class ProductListPresenter implements ProductListContract.Presenter {

  public static String TAG = ProductListPresenter.class.getSimpleName();

  private WeakReference<ProductListContract.View> view;
  private ProductListState state;
  private ProductListContract.Model model;
  private ProductListContract.Router router;

  public ProductListPresenter(ProductListState state) {
    this.state = state;
  }

  @Override
  public void injectView(WeakReference<ProductListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ProductListContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchProductListData() {
    // Log.e(TAG, "fetchProductListData()");

    // call the model
    state.products = model.fetchProductListData();

    view.get().displayProductListData(state);

  }


  @Override
  public void selectProductListData(ProductItem item) {
    //router.passDataToProductDetailScreen(item);
    router.passDataToProductDetailScreen(item.id);
    router.navigateToProductDetailScreen();
  }


}
