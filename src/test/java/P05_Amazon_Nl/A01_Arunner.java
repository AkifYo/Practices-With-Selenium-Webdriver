package P05_Amazon_Nl;

public class A01_Arunner {
    public static void main(String[] args) throws InterruptedException {
        A01_SetUp.setUp();
        A01_SetUp.cookiesHandle();
        Thread.sleep(3000);
        A02_Search_Product.searchProduct("galaxy a04");

        Thread.sleep(3000);
        A03_Review_Stars.reviewStar(1);
        A01_SetUp.finishTest();
    }
}
