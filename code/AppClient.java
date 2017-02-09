
import java.rmi.registry.*;

public class AppClient {
    public static void main(String[] argv) {
        int port = 10000;  // le port

        try {
            // on se connecte au serveur
            Registry registry = LocateRegistry.getRegistry(port);

            // on cree le stub pour connaitre les methodes utilisable sur le serveur "Fibonacci"
            Interface stub = (Interface) registry.lookup("Fibonacci");

            // on execute et on affiche le resultat
            System.out.println(stub.fibonacci(100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
