
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix={
				{0,20,30,10,0,0,0,0},
				{0,0,50,0,10,0,0,0},
				{0,10,0,7,0,3,0,0},
				{0,0,8,0,0,0,9,0},
				{0,5,0,0,0,10,0,20},
				{0,0,7,0,9,0,5,17},
				{0,0,0,10,0,12,0,5},
				{0,0,0,0,0,0,0,0}
		};
		FordFulkerson p=new FordFulkerson(8);
		int maximo=p.fordFulkerson(matrix, 0, 7);
		int[][] r=p.getResidualGrapH();
		System.out.println("FLUJO MAXIMO "+maximo);
		
	}

}
