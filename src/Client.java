import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
           Scanner scanner = new Scanner(System.in);
           String s = scanner.nextLine();
           System.out.println(service.reverse(s));
           s= scanner.nextLine();
           System.out.println(service.minChar(s));
           s= scanner.nextLine();
           System.out.println(service.upperLower(s));
           scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
