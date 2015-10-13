package arbol;

import java.awt.List;
import java.util.ArrayList;

public class main {
	
	final static  int inf=9999;
	static ArrayList<Integer> c=new ArrayList<Integer>();
	static ArrayList<Integer>c_c=new ArrayList<Integer>();
	static int[][] resultado;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{inf,4,inf,inf,inf,inf,10},
						{4,inf,3,inf,1,inf,inf},
						{inf,3,inf,11,inf,inf,inf},
						{inf,inf,11,inf,2,inf,inf},
						{inf,1,inf,2,inf,3,1},
						{inf,inf,inf,inf,3,inf,2},
						{10,4,inf,inf,inf,inf,10}};
		resultado=new int[matrix.length][matrix.length];
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				resultado[i][j]=inf;
			}
		}
		expansionminima(matrix);
	}
	public static void expansionminima(int[][] matrix)
	{
		for(int i=0;i<matrix.length;i++)
		{
			c_c.add(i);
		}
		//paso 1
		Integer aux=c_c.get(1);
		c_c.remove(aux);
		c.add(aux);
		while(c_c.size()>0)
		{
			Integer j=buscarMinimo(matrix);
			//borrar(j);
			c_c.remove(j);
			c.add(j);
		}
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				System.out.print(resultado[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static  int buscarMinimo(int[][] matrix)
	{
		int menor=999;
		int nodo=-1;
		for(int i=0;i<c.size();i++)
		{
			int index=c.get(i);
			for(int j=0;j<c_c.size();j++)
			{
				int indexj=c_c.get(j);
				if(matrix[index][indexj]!=inf&&matrix[index][indexj]<menor)
				{
					menor=matrix[index][indexj];
					nodo=indexj;
					resultado[index][indexj]=matrix[index][indexj];
					resultado[indexj][index]=matrix[indexj][index];
				}
			}
		}
		return nodo;
	}
}