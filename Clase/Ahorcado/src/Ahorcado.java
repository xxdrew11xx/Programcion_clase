import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        String word = "";
        char letter = ' ';
        boolean verif = true;

        System.out.println();

        Scanner sc = new Scanner(System.in);

           do 
           {
            System.out.print("[+] Introduce una palabra: ");
            word = sc.next();

            char acertado[] = new char [word.length()], fallo[] = new char [word.length()];

            char[] palabra = word.toCharArray();
            
            acertado[0] = palabra[0];
            acertado[word.length()-1] = palabra[word.length()-1];

            fallo[0] = palabra[0];
            fallo[word.length()-1] = palabra[word.length()-1];

            for(int i = 1; i < word.length()-1; i++)
            {

                acertado[i] = '_';
                fallo [i] = '_';

            }

            for(int i = 0; i < word.length()*2; i++)
            {

                do
                {
                    System.out.print("\n[+] Introduce una letra: ");
                    letter = (char) System.in.read();
                    while(System.in.read() != '\n');
                }
                while(letter == '\n');    

                for(int j = 0; j < word.length(); j++)
                {

                    if( letter == palabra[j])
                    {

                        acertado[j] = letter;
                        break;

                    }
                    else if( j == word.length()-1)
                    {

                        for(int s = 0; s < word.length(); s++)
                        {

                            if(fallo[s] == '_')
                            {

                                fallo[s] = letter;
                                break;

                            }

                        }

                    }


                }

                System.out.print("\n[!] PALABRA: ");

                for(int z = 0; z < word.length(); z++)
                {

                    System.out.print(acertado[z]);

                }

                System.out.println();

                System.out.print("\n[!] FALLOS: ");

                for(int z = 0; z < word.length(); z++)
                {

                    System.out.print(fallo[z]);

                }

                System.out.println("\n");

                for(int h = 0; h < fallo.length; h++)
                {

                    if(fallo[h] == '_')
                    {

                        break;

                    }
                    else if(h == fallo.length -1)
                    {

                        System.out.println("La palabra era: " + word);
                        i = word.length()*2;

                    }

                }

            }

            System.out.println();

            do 
            {

            System.out.print("\n[?] Quires jugar otra vez: ");
            System.out.print("\n[I] SI ---------> s");
            System.out.print("\n[I] NO ---------> n");
            System.out.print("\n------------------> ");
            letter = (char) Character.toUpperCase(System.in.read());
            while(System.in.read() != '\n');
                
            } while (letter != 'S' && letter != 'N');

            switch (letter) {
                case 'S':

                    verif = true;                
                    break;
            
                default:
                    verif=false;
                    break;
            }

           } 
           while (verif != false);
            

        sc.close();

    }
}
