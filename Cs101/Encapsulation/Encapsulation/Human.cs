using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Encapsulation
{
    class Human
    {
        private int eyes;

        public int GetEyes()
        {
            return eyes;
        }
        public void SetEyes(int eyes)
        {
            this.eyes = eyes;
        }
    }
}
