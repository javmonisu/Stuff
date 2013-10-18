using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        const string string_name = "APP_DATA";

        static void Main(string[] args)
        {
            bool boolean;
            byte bytes;
            char unicodeChar;
            decimal deci;
            double theD;
            float Float;
            int entry;
            long length;
            ulong veryLong=100;
            String text = "hello world";
            Console.WriteLine(veryLong.ToString()+" "+veryLong.ToString());
            entry = Convert.ToInt32(Console.ReadLine());
            //char* pointer;
            referenceTypes();
        }
        public static void referenceTypes()
        {
            //Object Type
            object obj = 100;
            obj = 100;
            //Dynamic Type
            dynamic variable = 100;
            Console.WriteLine(variable);
            variable = "hello";
            Console.WriteLine(variable);
            Console.ReadKey();
        }
    }
}
