
import java.util.*;

public class Serveur implements Interface {
    private HashMap <Integer,Double> fibo_results;
    private int number;  // dernier nombre calculé pour connaitre l'etat du cache
    private boolean fast_mode;  // utilisation de l'algorithme rapide
    private boolean cache_mode;  // utilisation d'un cache pour les resultats

    public Serveur() {  // Constructeur
        this(false, false);
    }

    public Serveur(boolean fast_and_cache) {
        this(fast_and_cache, fast_and_cache);
    }

    public Serveur(boolean fast, boolean cache) {
        fast_mode = fast;
        cache_mode = cache && fast;
        fibo_results = new HashMap <> ();
        number = 1;
        // known values :
        ajoutResult(0,0);
        ajoutResult(1,1);
    }

    private void ajoutResult(int n, double result) {
        fibo_results.put(new Integer(n), new Double(result));
    }


    public double fibonacci(int n) {  // implements "Interface"
        if (n <= 0)
            return 0;
        if (fast_mode)
            if (cache_mode)
                return loopCachedFibonaci(n);
            else
                return loopFibonacci(n);
        else
            return recFibonacci(n);
    }

    private double recFibonacci(int n) {  // recursive based algorithm, complexity = 2^n
        if (n <= 1)
            return n;
        else
            return recFibonacci(n - 1) + recFibonacci(n - 2);
    }

    private double loopFibonacci(int n) {  // loop based algorithm, complexity =~ 2*n
        if (n == 1 || n == 2)
            return 1;
        double fibo1 = 1; 
        double fibo2 = 1;
        double result = 1;
        for (int i = 3; i <= n; i++) {
            result = fibo1 + fibo2;  // Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = result;

        }
        return result;
    }

    private double loopCachedFibonaci(int n) {  // loop based algorithm with result caching, complexity =< "loop_fibonacci"
        if (n <= number)  // == fibo_results.contains(n)
            return fibo_results.get(n);
        double fibo1 = fibo_results.get(number - 1);
        double fibo2 = fibo_results.get(number);
        double result = 0;
        for (int i = number + 1; i <= n; i++) {
            result = fibo1 + fibo2;  // Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = result;
            ajoutResult(number = i, result);  // garder en cache le resultat
        }
        return result;
    }
}
