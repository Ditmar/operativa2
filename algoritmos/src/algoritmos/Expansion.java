package algoritmos;

import java.util.Vector;

public class Expansion {
	private int INF=9999;
	private int[][] resultado;
	private Vector<Nodo> lista1,lista2;
	private int[][]matrix;
	public Expansion()
	{
		 int[][] mm={{INF,1,10,3},
				 		 {1,INF,2,2},
				 		 {10,2,INF,1},
				 		 {3,2,1,INF}
		 					};
		 matrix=mm;
		 lista1=new Vector<Nodo>();
		 lista2=new Vector<Nodo>();
		 this.resultado=new int[matrix.length][matrix.length];
	}
	public int[][] solve()
	{
		int len=matrix.length;
		String[] label={"a","b","c","d"};
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				this.resultado[i][j]=INF;
			}
		}
		for(int i=0;i<len;i++)
		{
			Nodo p=new Nodo();
			p.label=label[i];
			p.i=i;
			lista1.add(p);
		}
		//PASO1
		Nodo aux=lista1.get(0);
		lista2.add(aux);
		lista1.remove(aux);
		while(lista1.size()>0)
		{
			//buscar al menor nodo conectado
			Nodo nodo=busqueda();
			lista2.add(nodo);
			lista1.remove(nodo);
		}
		return this.resultado;
	}
	public Nodo busqueda()
	{
		Nodo nodo=null;
		Nodo nodop=null;
		int menor=9999;
		for(int i=0;i<lista2.size();i++)
		{
			 Nodo p1=lista2.get(i);
			for(int j=0;j<lista1.size();j++)
			{
				Nodo nodoaux=lista1.get(j);
				int aux=matrix[p1.i][nodoaux.i];
				if(aux<menor)
				{
					menor=aux;
					nodo=nodoaux;
					nodop=p1;
				}
			}
		}
		this.resultado[nodop.i][nodo.i]=matrix[nodop.i][nodo.i];
		this.resultado[nodo.i][nodop.i]=matrix[nodo.i][nodop.i];
		return nodo;
	}
}
