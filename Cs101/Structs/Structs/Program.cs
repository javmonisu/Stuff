using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

struct Person
{
    public String name;
    public int age;
};
namespace Structs
{
  
    class Program
    {
        
        public static void Main(string[] args)
        {
            Person p = new Person();
            p.name = "Jax";
            p.age = 32;
            Console.WriteLine("Name:"+ p.name + " Age:" + p.age);
            Console.ReadKey();
            
        }
    }
}
