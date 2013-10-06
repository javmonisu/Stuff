using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Polimorfismo
{
    class Print
    {
        public void number(int number)
        {
            Console.WriteLine("Printing integer {0}", number);
        }
        public void number(double number)
        {
            Console.WriteLine("Printing float {0}", number);
        }
        public void number(string number)
        {
            Console.WriteLine("Printing string {0}", number);
        }
    }
    class Program
    {        
        static void Main(string[] args)
        {
            staticPolimorphism();
            
        }
       
        public static void staticPolimorphism(){
            //Function overloading.
            Print p = new Print();
            p.number(1);
            p.number(1.5);
            p.number("hola");
            Console.ReadKey();
        }
    }
}
