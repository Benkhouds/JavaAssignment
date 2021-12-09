import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
    public String reverse(String s) throws RemoteException;
    public char minChar(String s) throws RemoteException;
    public String upperLower(String s) throws RemoteException;
}
