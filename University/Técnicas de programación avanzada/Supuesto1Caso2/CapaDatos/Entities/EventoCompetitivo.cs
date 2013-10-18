using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CapaDatos.Entities
{
    class EventoCompetitivo : Evento
    {
        private String fecha;

        public String Fecha
        {
            get { return fecha; }
            set { fecha = value; }
        }
        private String localidad;

        public String Localidad
        {
            get { return localidad; }
            set { localidad = value; }
        }
        private String direccion;

        public String Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }
        private int telefonoContacto;

        public int TelefonoContacto
        {
            get { return telefonoContacto; }
            set { telefonoContacto = value; }
        }
    }
}
