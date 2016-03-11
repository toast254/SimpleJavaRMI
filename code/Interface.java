
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote
{
    public double fibonacci(int n) throws RemoteException;
}
