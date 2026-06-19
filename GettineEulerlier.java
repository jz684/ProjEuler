import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GettineEulerlier {
    public static void main (String[] args){//this is where im running each function to see if it works
        long input = 600851475143L ;//600851475143L
        System.out.println(primeTime(input));
    }

    //question 3
    //just have to find the largest prime factor
    public static long primeTime(long target){
        HashSet<Long> facts = factoring(target);
        
        ArrayList<Long> passing = new ArrayList<>();//wanted to try to not do array list but i think i might need to unless I want to rewrite 
        //im gonna try to shortcut and just check the large numbers without even trying the small ones
        for(long i : facts){
            if(factoring(i).size() == 1){//should just be one and itself
                passing.add(i);
            }
        }
        long largest = 0;
        for(long i :passing){
            if(largest < i){
                largest = i;
            }
        }
        return largest;

        //return -111111111111L;//I goofed if its this
    }
    //helpers for question 3
    public static boolean isSame(Long val , Long targ){//this will show if the numbers are the same
        if(targ / val * val == targ){
            return true;
        }
        return false;
    } // O(1)

    public static HashSet factoring(long target){
        HashSet<Long> facts = new HashSet<>();
        //finding the factors
        for(long i = 1 ; i<target ; i++){//O(n) bc each number needs to be checked
            if(isSame(i, target) && !facts.contains(target/i)){
                facts.add(target/i);
            }
        }
        // System.out.print(target + ": "); //helped me find the variables that actually went into the list
        // for(long i : facts){
        //     System.out.print(i + " ");
        // }
        // System.out.println("");
        return facts;
    }


    //question 2
    public static long evenFibbier(long term1, long term2, long ret){
        
        if (term2%2 == 0){
            ret += term2;
            System.out.println(term2);
        }
        if(term2 >= 4000000){
            return ret;
        }
        return evenFibbier(term2, term1+term2, ret);
    }

     //question 1
     public static long threeOrFive(long size){
        long ret=0;
        for(long i = 3 ; i<size; i+=3){
            ret += i;
        }
        for(long i = 5 ; i<size; i+=5){
            ret += i;
        }
        for(long i = 15 ; i<size; i+=15){
            ret -= i;
        }
        return ret;
    }

    //to sign up question
    public static long squaringUp(long intake){
        long ret = 0;
        for(long i =1; i <=664000; i+=2){
            ret += i*i;
        }
        System.out.println(ret);
        return ret;
    }

   

}
