using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    /**
     *Commentary 
     * 
     */
    class Rectangle
    {
        public void calculateArea(long length, long width)
        {
            display(length * width);
        }
        public void display(long area)
        {
            Console.WriteLine(area);
        }
    }
    class Program
    {  
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the length");
            Rectangle rectangle = new Rectangle();
            long a, b;           
            a = (long)Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Enter the width");
            b = (long)Convert.ToDouble(Console.ReadLine());
            rectangle.calculateArea( a, b);
            Console.ReadKey();
           
        }
    }
}
