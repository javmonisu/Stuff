using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interfaces
{
       
    class Program : INumber
    {
        static int number;
        static void Main(string[] args)
        {
            number = 1; 
        }
         public void setNumber(int num){
            number = num;
        }
         public int getNumber(){
            return number;
        }
    }
}
