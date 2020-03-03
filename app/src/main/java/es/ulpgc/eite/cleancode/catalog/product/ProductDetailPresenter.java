package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;


public class ProductDetailPresenter implements ProductDetailContract.Presenter {

  public static String TAG = ProductDetailPresenter.class.getSimpleName();

  private WeakReference<ProductDetailContract.View> view;
  private ProductDetailState state;
  private ProductDetailContract.Model model;
  private ProductDetailContract.Router router;

  public ProductDetailPresenter(ProductDetailState state) {
    this.state = state;
  }

  @Override
  public void injectView(WeakReference<ProductDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ProductDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchProductDetailData() {
    // Log.e(TAG, "fetchProductDetailData()");

    // set passed state
    Integer productId = router.getDataFromProductListScreen();
    if (productId != null) {
      state.product = model.getProduct(productId);
    }

    /*
    ProductItem product = router.getDataFromProductListScreen();
    if(product != null) {
        state.product = product;
    }
    */

    view.get().displayProductDetailData(state);
  }

}
