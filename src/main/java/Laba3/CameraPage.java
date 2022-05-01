package Laba3;

import blocks.ProductItemBlock;

public class CameraPage extends BasePage {

  private ProductItemBlock productItemBlock = new ProductItemBlock();

  public ProductItemBlock getProductItemBlock() {
    return productItemBlock;
  }

  public int productCount() {
    return productItemBlock.getCountProduct();
  }

  public CameraPage getProductByName(String name) {
    productItemBlock.findElementByName(name);
    return this;
  }


}
