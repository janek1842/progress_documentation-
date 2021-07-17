package exercises;

import java.util.Arrays;

/** TODO
 * Jako rozgrzewkę, spróbuj pobawić się tym kodem.
 * Zrozum jego działanie, a następnie zepsuj go w taki sposób, aby był jak najmniej czytelny, ale wciąż działał
 * (testowanie czy kod działa jest również częścią zadania)
 *
 * ### Kod zaczerpnięty z książki "Czysty Kod" Robert C. Martin ###
 */

public class liczbyPierwsze
{
    //first part of the function
    private static boolean[] Przekres;
    private static int[] wyn;
//funkcja generująca liczby pierwsze
    public static int[] liczbyPierwsze(int maximal) {
        if (maximal < 2) return new int[0];
        else { Przekres = new boolean[maximal + 1];
            for (int i = 2; i < Przekres.length; i++) {
                Przekres[i] = false;
//Is that function generating proper results ? Don't know
            }

            double it_Limit = Math.sqrt(Przekres.length);
            int limit =  (int) it_Limit;

// for loop

            for (int i = 2; i <= limit; i++)
                if (notPrzekreslony(i)){ for (int multiple = 2 * i; multiple < Przekres.length; multiple += i)
                    Przekres[multiple] = true;
                }

            int count = 0;
            for (int i = 2; i < Przekres.length; i++) { if (notPrzekreslony(i)) count++;
            }
// Another part of the function
            wyn = new int[count];
            for (int j = 0, i = 2; i < Przekres.length; i++)
                if (notPrzekreslony(i)) wyn[j++] = i;
// returning result
            return wyn;
        }
    }

    private static boolean notPrzekreslony(int i)
    {
        return Przekres[i] == false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(liczbyPierwsze.liczbyPierwsze(100)));
    }

}
