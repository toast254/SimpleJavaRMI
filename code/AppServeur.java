
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AppServeur
{
    public static void main(String[] argv)
    {
        // le port
        int port = 10000;

        try
        {
            // creation du stub/skeleton vers le traitement
            Interface skeleton = (Interface) UnicastRemoteObject.exportObject(new Serveur(true), port);

            // on cree le serveur
            Registry registry = LocateRegistry.createRegistry(port);

            // publication de notre serveur sous le nom "Fibonacci" avec le traitement defini dans notre stub/skeleton
            registry.rebind("Fibonacci", skeleton);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
