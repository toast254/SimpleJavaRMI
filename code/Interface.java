
import java.rmi.*;

public interface Interface extends Remote {
    // la methode que le serveur expose au client
    public double fibonacci(int n) throws RemoteException;
}
