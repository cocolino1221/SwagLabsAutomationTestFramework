package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Product {
    public final SelenideElement link;
    private final String name;
    private final String price;
    private final SelenideElement addToCartButton;
    private final SelenideElement deleteFromCart;
    private final String productId;
    private final SelenideElement productPicture;

    public Product(String productId, String name, String price) {
        this.productId = productId;
        String productLink = String.format("#item_%s_title_link", productId);
        this.link = $(productLink);
        this.name = link.getText();
        SelenideElement parentCard = link.parent().parent();
        this.price = parentCard.$(".inventory_item_price").getText();
        this.addToCartButton = parentCard.$(".btn_primary");
        this.deleteFromCart = parentCard.$(".btn_secondary");
        this.productPicture = parentCard.$(".inventory_item_img");
    }

    public boolean validatePriceExist() {
        return !this.price.isEmpty();
    }

    public boolean validateAddToCartButtonExist() {
        return this.addToCartButton.isDisplayed() && this.addToCartButton.isEnabled();
    }

    public boolean validatePictureIsDisplayed() {
        return this.productPicture.isDisplayed() && this.productPicture.isImage();
    }

    public boolean validateProductTitleExist() {
        return this.name.isEmpty();
    }


    public String getProductId() {
        return productId;
    }

    public void addToCart() {
        this.addToCartButton.click();

    }

    public String getName() {
        return name;
    }
    public boolean validateIfProductExist(){
        return !this.productId.isEmpty();
    }
    public void clickDeleteFromClick(){
        deleteFromCart.click();
    }
}