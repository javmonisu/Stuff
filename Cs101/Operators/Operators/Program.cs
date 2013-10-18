using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            float a=100, b=50, c;
            c = a + b;
            Console.WriteLine(c);
            c = a - b;
            Console.WriteLine(c);
            c = a * b;
            Console.WriteLine(c);
            c = a / b;
            Console.WriteLine(c);
            c = a % b;
            Console.WriteLine(c);
            c++;
            Console.WriteLine(c);
            c--;
            c += a;
            c = +a;
            Console.ReadKey();
            //Comparators and Logical Operators work as they do in Java.
        }
    }
}
