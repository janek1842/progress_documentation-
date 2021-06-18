public class Zadanie1 {
    public static void main(String[] args) {

        System.out.println("Start");
        int zakres = 50;

        if (args.length > 0)
            if (Integer.parseInt(args[0]) > 0)
                zakres = Integer.parseInt(args[0]);
		
        for (int i = 0; i < zakres; i++) {
			for (int t=0;t<i;t++){
                System.out.print("*");				
			}
			System.out.println("");
        }

        System.out.println("Koniec");
		
    }
}
