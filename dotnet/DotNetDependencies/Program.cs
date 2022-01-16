using System.Diagnostics;
using Humanizer;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Quantities:");
            HumanizeQuantities();

            Console.WriteLine("\nDate/Time Manipulation:");
            HumanizeDates();

            Fibonacci(2);
            Fibonacci(4);
            Fibonacci(8);

        }

        static int Fibonacci(int n)
        {
            Debug.WriteLine($"Entering {nameof(Fibonacci)} method");
            Debug.WriteLine($"We are looking for the {n}th number");
            int sum = 0, n1 = 0 , n2 = 0;
            for (int i = 2; i <= n; i++)
            {                  
                sum = n1 + n2;
                n1 = n2;
                n2 = sum;
                Debug.WriteLineIf(sum == 1, $"sum is 1, n1 is {n1}, n2 is {n2}");    
            }

            // If n2 is 5 continue, else break.
            //Debug.Assert(n2 == 5, "The return value is not 5 and it should be.");
            return n == 0 ? n1 : n2;
        }


        static void HumanizeQuantities()
        {
            Console.WriteLine("case".ToQuantity(0));
            Console.WriteLine("case".ToQuantity(1));
            Console.WriteLine("case".ToQuantity(5));
        }

        static void HumanizeDates()
        {
            Console.WriteLine(DateTime.UtcNow.AddHours(-24).Humanize());
            Console.WriteLine(DateTime.UtcNow.AddHours(-2).Humanize());
            Console.WriteLine(TimeSpan.FromDays(1).Humanize());
            Console.WriteLine(TimeSpan.FromDays(16).Humanize());
        }
    }
}

