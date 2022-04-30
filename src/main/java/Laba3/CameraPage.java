package Laba3;

import blocks.ProductItemBlock;

public class CameraPage extends BasePage {

  private ProductItemBlock productItemBlock = new ProductItemBlock();

  public void findCamera(String name) {
    productItemBlock.findElementByName(name);
  }


}
