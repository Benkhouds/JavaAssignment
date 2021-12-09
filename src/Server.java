import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }

    @Override
    public String  reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    @Override
    public char minChar(String s){
        char c =s.charAt(0);
        for (int i = 1; i <s.length()  ; i++) {
            if(s.charAt(i) < c){
                c=s.charAt(i);
            }
        }
        return c;
    }
    @Override
    public String upperLower(String s){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) >='a' && s.charAt(i) <='z'){
                res.append((char)(s.charAt(i) - 32));
                /*res.append(Character.toString(s.charAt(i)).toUpperCase(Locale.ROOT));*/

            }else if(s.charAt(i) >='A' && s.charAt(i) <='Z'){
                res.append((char)(s.charAt(i) + 32));
                /*res.append(Character.toString(s.charAt(i)).toLowerCase(Locale.ROOT));*/
            }else{
               res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

}
