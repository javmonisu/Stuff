/*
 * Copyright (C) 2013 Javier Montero
 *				 2010 Javier Montero
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */


#include <stdio.h>
#include <stdlib.h>
#define N 15
/*Laberinto de 15x15*/

char maze[N][N]={{'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		   {'#',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#','#','#'},
		   {'#',' ',' ',' ','#','#',' ',' ',' ','#',' ',' ',' ','#'},
		   {'#',' ',' ',' ',' ','#',' ','#',' ','#',' ','#',' ','#'},
		   {'#','#',' ',' ',' ',' ',' ','#',' ','#',' ','#',' ','#'},
		   {'#',' ','#','#','#','#',' ','#',' ',' ',' ','#',' ','#'},
		   {'|',' ',' ',' ',' ',' ','#',' ',' ','#',' ','#',' ','#'},
		   {'#',' ','#','#','#',' ','#','#',' ','#',' ',' ',' ','#'},
		   {'#',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#',' ','#'},
		   {'#',' ','#','#',' ','#','#','#',' ','#','#','#',' ','#'},
		   {'#',' ',' ',' ',' ',' ',' ','#',' ','#',' ',' ',' ','#'},
		   {'#',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
           {'#',' ',' ',' ',' ',' ',' ','#',' ','#',' ',' ',' ','#'},
		   {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};

/*Funcion de mostrado por pantalla*/

void pantalla (int a, int b)
{
	   for(a=0;a<15;a++) {

				for(b=0;b<15;b++)
						printf(" %c ", maze[a][b]);
						printf("\n");

			     }
}

int mov_prisionero(int w, int z)
{
	/*Si encuentra la salida..*/
	if(maze[w+1][z]=='|' || maze[w-1][z]=='|' || maze[w][z+1]=='|' || maze[w][z-1]=='|')
	{
			return 1;
	}
	else if(maze[w-1][z]==' ')
	{
		maze[w][z]='.';
		maze[w-1][z]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w-1,z);
	}
	else if(maze[w+1][z]==' ')
	{
		maze[w][z]='.';
		maze[w+1][z]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w+1,z);
	}
	else if(maze[w][z+1]==' ')
	{
		maze[w][z]='.';
		maze[w][z+1]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w,z+1);
	}
	else if(maze[w][z-1]==' ')
	{
		maze[w][z]='.';
		maze[w][z-1]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w,z-1);
	}

	else if(maze[w+1][z]=='.')
	{
		maze[w][z]=',';
		maze[w+1][z]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w+1,z);
	}

	else if(maze[w-1][z]=='.')
	{
		maze[w][z]=',';
		maze[w-1][z]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w-1,z);
	}

	else if(maze[w][z+1]=='.')
	{
		maze[w][z]=',';
		maze[w][z+1]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w,z+1);
	}

	else if(maze[w][z-1]=='.')
	{
		maze[w][z]=',';
		maze[w][z-1]='O';
		pantalla(w,z);
		getchar();
		mov_prisionero(w,z-1);
	}
	else
	{
		printf("\nNo existe posibilidad de escapar.\n");
		exit (0);

	}
};

void main()
{
	int xo,yo,x,valida;
	printf("Programa maze\n");
	/*Do-While creado para una entrada correcta de datos*/
	do {
		x=1;
		/*Valores donde aparecerá el prisionero del maze(laberinto)*/
		printf("\nIntroduce el valor inicial en el eje X :");
		scanf("%d",&yo);
		yo=yo-1;
		printf("\nIntroduce el valor inicial en el eje Y :");
		scanf("%d",&xo);
		xo=xo-1;

		if(maze[yo][xo]=='#')
		  {
			printf("\nPosicion inicial ocupada por una pared,por favor, inserte una posicion no ocupada en el laberinto(2x2 por ejemplo).\n");
			x=0;
		  }

		else if(maze[xo][yo]==' ')
		  {
		    printf("\nPosicion inicial correcta.\n");
		    maze[xo][yo]='0';
		    pantalla(xo,yo);
		    valida=mov_prisionero(xo,yo);

		    if(valida==1)
			{
				printf("He conseguido salir del laberinto!!\n");
		  	}
		  }
		else
		  {
			printf("\nPosicion inicial incorrecta(fuera del laberinto),por favor, inserte una posicion dentro del laberinto.");
			x=0;
		  }
	} while(x==0);
}


