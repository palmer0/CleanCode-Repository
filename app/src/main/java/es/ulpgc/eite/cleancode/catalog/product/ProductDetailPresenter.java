package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;


public class ProductDetailPresenter implements ProductDetailContract.Presenter {

  public static String TAG = ProductDetailPresenter.class.getSimpleName();

  private WeakReference<ProductDetailContract.View> view;
  private ProductDetailState state;
  private ProductDetailContract.Model model;
  //private ProductDetailContract.Router router;
  private CatalogMediator mediator;

  public ProductDetailPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getProductDetailState();
  }

//  public ProductDetailPresenter(ProductDetailState state) {
//    this.state = state;
//  }

  @Override
  public void injectView(WeakReference<ProductDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductDetailContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(ProductDetailContract.Router router) {
//    this.router = router;
//  }

  private Integer getDataFromProductListScreen() {
    Integer productId = mediator.getProductId();
    return productId;
  }

  @Override
  public void fetchProductDetailData() {
    // Log.e(TAG, "fetchProductDetailData()");

    // set passed state
    Integer productId = getDataFromProductListScreen();
    //Integer productId = router.getDataFromProductListScreen();
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
