package P05_Amazon_Nl;

public class A01_Arunner {
    public static void main(String[] args) throws InterruptedException {
        A01_SetUp.setUp();
        A01_SetUp.cookiesHandle();
        Thread.sleep(5000);
        A02_Search_Product.searchProduct("samsun galaxy a04");
        A01_SetUp.finishTest();
    }
}
