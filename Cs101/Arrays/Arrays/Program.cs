using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arrays
{
    class Program
    {
        public static void biggerNumber(int[] numbers)
        {
            int bigger = 0;
            for (int i = 0; i<numbers.Length ; i++)
            {
                if (numbers[i] > bigger)
                {
                    bigger = numbers[i];
                }
            }
            Console.WriteLine(bigger.ToString()+"\n");
        }
        static void Main(string[] args)
        {
            String[][][] array;
            int[] array2 = new int[100];
            for (int i = 0; i < 100; i++)
            {
                array2[i] = (i+1);
            }
            foreach (int j in array2)
            {
                Console.WriteLine(j);
                
            }
            int [] aux = new int[] { 300, 200, 100, 30030, 203 };
            biggerNumber(aux);
            Array.Sort(aux);
            foreach (int i in aux)
            {
                Console.Write(i+" ");
            }
            Console.WriteLine();
            Array.Reverse(aux);
            foreach (int i in aux)
            {
                Console.Write(i + " ");
            }
            
            Console.ReadKey();
        }
    }
}
