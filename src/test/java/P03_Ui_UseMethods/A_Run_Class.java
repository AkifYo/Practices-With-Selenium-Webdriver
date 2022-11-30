package P03_Ui_UseMethods;

public class A_Run_Class {
    public static void main(String[] args) throws InterruptedException {
        B_FirstMethods.setUp();
        B_FirstMethods.cookiesHandle();
        C_Search_Box.searchText("google");
        D_Price.priceControl("90","1500");
        E_Review.chooseStars(5);
        B_FirstMethods.finishTest();
    }



}
