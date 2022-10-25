import org.testng.annotations.Test;

public class SecondTestcase {


    @Test(priority = 1)
    void secondsetup(){
        System.out.println("bonjour");
    }
    @Test(priority = 2)
    void secondlogin(){
        System.out.println("authentification user");
    }
    @Test(priority = 3)
    void secondteardown(){
        System.out.println("test is finish");
    }
}
