public class Zadanie3 {
    public static void main(String[] args) {

        System.out.println("Start");
        int zakres = 50;

        if (args.length > 0)
            if (Integer.parseInt(args[0]) > 0)
                zakres = Integer.parseInt(args[0]);
		
		int s=0;
		
		for(int j=zakres;j>0;j=j-1){
			s=0;
			for (int i = j-1; i > 1; i=i-1) {
				if(j%i==0){
					s=s+1;
				}
			}
			if(s==0){
				System.out.print(j+",");
			}	
		}
		
		
		
        
    }
}
