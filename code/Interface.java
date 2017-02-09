
import java.rmi.*;

public interface Interface extends Remote {
    public double fibonacci(int n) throws RemoteException;
}
