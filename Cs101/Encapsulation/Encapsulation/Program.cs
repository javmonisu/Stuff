using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Encapsulation
{
   
    class Program
    {
        static void Main(string[] args)
        {
            Human h = new Human();
            h.SetEyes(2);
            Console.WriteLine(h.GetEyes());
            Console.ReadKey();
        
        }
    }
}
