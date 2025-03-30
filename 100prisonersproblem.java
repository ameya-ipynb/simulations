import java.util.*;
public class prisonerproblem100
{ //class variables
    static int box[] = new int[100];
    static int prisoners[] = new int[100]; 
    static int data[] = new int[100];
    static boolean alive = true;
    static void main() 
    {   int live=0, die=0;
        double average=0.0;
  
        for (int i = 0; i<100; i++)
        {
            box[i] = i+1;
            prisoners[i] = i+1;
        }
        
        for(int i = 0; i<10000000; i++)
        {
            shuffle();
            alive = find();
            average+= report(alive);
            if (alive)
            live++;
            else
            die++;
        }
        System.out.println("Probability of being alive =" + live/100000.0 + "% \n Probability of dying =" + die/100000.0 + "%");
        System.out.println("Average no. of steps required =" + average/10000000);
    }
    static void shuffle()
    {
    Random rand = new Random();  
    
    for (int i = 99; i > 0; i--)  // Fisher-Yates shuffle
        {   
        int randomIndex = rand.nextInt(i + 1);  
        int temp = box[i];
        box[i] = box[randomIndex];
        box[randomIndex] = temp;
        }
    }
    static boolean find()
    {   
    boolean allSurvive = true; 

    for (int i = 0; i < 100; i++)  
    {   
        int n = i, k = 0;  

        while (true)  
        {   
            k++;
            if (prisoners[i] == box[n])  
            {
                break;
            }
            else 
            { 
                n = box[n] - 1;  
            }

            if (k > 50)  
            {
                allSurvive = false;
            }
        }

        data[i] = k;  
    }
    
    return allSurvive;  
    }

    static double report(boolean b)
    {   double avg=0;
        alive = b;
        for(int i=0; i<100; i++)
        {
            avg += data[i];
        }
        avg = avg/100.0;
        return (avg);
    }
}
