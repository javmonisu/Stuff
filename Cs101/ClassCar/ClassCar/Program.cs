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
            Console.WriteLine("The car");
            String aux = Console.ReadLine();
            if (aux == "Turn on")
            {
                Car myCar = new Car(100);
                Console.WriteLine("Car is running");
                int fuel = myCar.getFuel();
                while (fuel != 0)
                {
                    Console.WriteLine("Fuel is running out!!");
                    System.Threading.Thread.Sleep(500);
                    fuel -= 10;
                }
                Console.WriteLine("Car out of fuel :( ");
                Console.ReadKey();
            }

        }
    }
}
