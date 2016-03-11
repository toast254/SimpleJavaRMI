
import java.util.*;

public class Serveur implements Interface
{
    private HashMap <Integer,Double> fibo_results;
    private int number;
    private boolean fast_mode;
    private boolean cache_mode;

    // Constructor
    public Serveur()
    {
        this(false, false);
    }

    public Serveur(boolean fast_and_cache)
    {
        this(fast_and_cache, fast_and_cache);
    }

    public Serveur(boolean fast, boolean cache)
    {
        fast_mode = fast;
        cache_mode = cache && fast;

        fibo_results = new HashMap <Integer, Double> ();

        number = 1;

        // known values
        ajout_result(0,0);
        ajout_result(1,1);
    }

    private void ajout_result(int n, double result)
    {
        fibo_results.put(new Integer(n), new Double(result));
    }

    // implements "Interface"
    public double fibonacci(int n)
    {
        if (n <= 0)
            return 0;

        if (fast_mode)
            if (cache_mode)
                return loop_cached_fibonaci(n);
            else
                return loop_fibonacci(n);
        else
            return rec_fibonacci(n);
    }

    // recursive based algorithm, complexity = 2^n
    private double rec_fibonacci(int n)
    {
        if (n <= 1)
            return n;
        else
            return rec_fibonacci(n-1) + rec_fibonacci(n-2);
    }

    // loop based algorithm, complexity =~ 2*n
    private double loop_fibonacci(int n)
    {
        if (n == 1 || n == 2)
        {
            return 1;
        }

        double fibo1=1, fibo2=1, result=1;

        for (int i = 3; i <= n; i++)
        {
            result = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = result;

        }
        return result;
    }

    // loop based algorithm with result caching, complexity =< "loop_fibonacci"
    private double loop_cached_fibonaci(int n)
    {
        if (n <= number) // == fibo_results.contains(n)
            return fibo_results.get(n);

        double fibo1 = fibo_results.get(number-1);
        double fibo2 = fibo_results.get(number);
        double result = 0;

        for (int i = number + 1; i <= n; i++)
        {
            // calculation details :
            //~ System.out.println(i + " : " + fibo1 + " + " + fibo2 + " > " + result);

            result = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = result;

            ajout_result(number = i, result);
        }

        return result;
    }
}
