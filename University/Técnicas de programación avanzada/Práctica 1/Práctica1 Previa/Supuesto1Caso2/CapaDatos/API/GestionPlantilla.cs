using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CapaDatos.Entities;
namespace CapaDatos.API
{
    class GestionPlantilla
    {
        private List<Jugador> jugadores;

        public List<Jugador> Jugadores
        {
            get { return jugadores; }
            set { jugadores = value; }
        }
        private List<PlantillaTecnica> equipoTecnico;

        public List<PlantillaTecnica> EquipoTecnico
        {
            get { return equipoTecnico; }
            set { equipoTecnico = value; }
        }
    }
}
