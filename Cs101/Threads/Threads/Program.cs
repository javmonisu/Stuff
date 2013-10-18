using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Threads
{
    class Program
    {
        public static void CallToChildThread()
        {
            Console.WriteLine("Child thread starts");
            Thread.Sleep(5000);
            Console.WriteLine("It has been sleeping 5 seconds");
        }
        static void Main(string[] args)
        {
            Thread th = Thread.CurrentThread;
            th.Name = "Main Thread";
            Console.WriteLine("This is {0}", th.Name);
            ThreadStart childThread = new ThreadStart(CallToChildThread);
            Thread newChild = new Thread(childThread);
            newChild.Start();
            //newChild.Abort();
            Console.ReadKey();

        }
    }
}
