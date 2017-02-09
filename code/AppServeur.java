
import java.rmi.registry.*;
import java.rmi.server.*;

public class AppServeur {
    public static void main(String[] argv) {
        int port = 10000;  // le port d'ecoute
        try {
            // creation du skeleton vers le traitement
            Interface skeleton = (Interface) UnicastRemoteObject.exportObject(new Serveur(true), port);
            // on cree le serveur
            Registry registry = LocateRegistry.createRegistry(port);
            // publication de notre serveur sous le nom "Fibonacci" avec le traitement defini dans notre skeleton
            registry.rebind("Fibonacci", skeleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
