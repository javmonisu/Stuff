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
            //The loop is expected.
            while (true)
            {

                int a = 0, b = 1;
                String c = b.ToString();
                if (a > 0)
                {
                    Console.WriteLine("Don't reach");
                }
                else if (a == 0)
                {
                    switch (c)
                    {
                        case "1":
                            for (int i = 1; i <= 100; i++)
                            {
                                if (i % 3 == 0)
                                {
                                    Console.WriteLine(i);
                                }
                            }
                            Console.ReadKey();
                            break;
                        default:
                            Console.WriteLine("Don't reach");
                            break;

                    }
                }
                else
                {
                    Console.WriteLine("Don't reach");
                }

            }
        }
    }
}
