package concurrent.producer_customer;

/**
 * Description：TODO
 * Create Time：2017/5/6 9:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Product {
    private int productNo;


    public Product(int productNo) {
        this.productNo = productNo;

    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }


}
