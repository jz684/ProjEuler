import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GettineEulerlier {
    public static void main (String[] args){//this is where im running each function to see if it works
        // long input = 600851475143L ;//600851475143L
        // System.out.println(primeTime(input));
        System.out.println(suPrime(2000000));
    }

    //question 10: Find the sum of all the primes below two million.
    //idea:just multiply a lot of numbers and see if a number has multiple factors
    public static long suPrime(int target){
        long[] list = new long[target+1];
        long result = 0;
        for(int i = 0; i <= target ; i++){//chose to use 2000000 as the bound bc you have to check the 1*2000000 scenario 
            for(int j = 0; j <= target && i*j>=0; j++){
                if(i*j <= target ){//dont really need to do the equals to bc 2000000 is obviously not prime, but why not just include'
                    list[i*j] += 1;
                }
            }
        }
        for(int i = 0; i < list.length; i++){
            //System.out.println(i + " : "+list[i]);
            if(list[i] == 2){
                //System.out.println("adding" + i);
                result+=i;
            }
        }
        return result;
    }

    //question 9: There exists exactly one Pythagorean triplet for which a+b+c=1000. Find the product abc.
    //doing a little math i got to: a+b+sqrt(a^2 + b^2) = 1000 --> 0=1000000-a2000-b2000. I'm not the surest 
    //on what my next step is supposed to be since i already plugged in for c, so the code will carry the rest
    public static void triplingUp(){
        for(int a = 1 ; a < 1000; a++){
            for(int b = 1 ; b < 1000; b++){
                for(int c = 1 ; c < 1000; c++){
                    if(check1(a, b, c) && check2(a, b, c)){
                        System.out.println("product of "+ a+ " "+ b+ " and "+c+" is "+ (a*b*c));
                    }
                }
            }
        }
        System.out.println("never happening");
    }

    public static boolean check1(int a, int b, int c){//this is the pythag identity
        if((a*a + b*b) == c*c){
            return true;
        }
        return false;
    }
    public static boolean check2(int a, int b, int c){//this is the a+b+c = 1000
        if(a+b+c == 1000){
            return true;
        }
        return false;
    }

    //question 8:Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
    //number list:
    //73167176531330624919225119674426574742355349194934969835203127745063262395783180169848018694788518438586156078911294949545950173795833195285320880
    //55111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866
    // 4523874930358907296290491560440772390713810515859307960866701724271218839987979087922749219016997208880937766572733300105336788122023542180975125
    // 4540594752243525849077116705560136048395864467063244157221553975369781797784617406495514929086256932197846862248283972241375657056057490261407972
    // 9686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456
    // 8284891288314260769004224219022671055626321111109370544217506941658960408071984038509624554443629812309878799272442849091888458015616609791913387
    // 54992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450
    //I was worried that this might not fit within a string, but ti should fit. 
    //Additionally this seems like a standard dynamic programming question where you can take the start number and multiply by the next 13 and then you can pick the largest
    public static void simpsons(){//bc it's a long show
        String given = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        
        String subsection = "";
        String where = "";
        long largest = 0;
        long working = 1;

        for(int i = 0; i<988 ; i++){
            subsection = given.substring(i,i+13);
            for(int j = 0; j<subsection.length() ; j++){
                working *= Integer.parseInt(subsection.substring(j,j+1));
            }
            if(largest < working){//check to see the largest
                largest = working;
                where = subsection;
            }
            System.out.println(largest + " : "+ where);
            working = 1;//reset for the next go
        }
        
    }

    //question 7:What is the  10001st prime number?
    //idea: Use the fact that computers can make hundreds of thousands of computations to just make an array that counts how many times a number is made
    //then move only the prime numbers to a second and grab the index we're looking for
    public static long optimousPrime(int curr, int have, int target){
        while(have < target){
            curr++;
            if(prime(curr)){
                have++;
            }
        }
        return curr;
    }

    public static boolean prime(int num){//tells if a number is prime
        for(int i = 2; i <= Math.sqrt(num); i++){//uses the idea that factors repeat after sqrt(n) and thhe fact that for a prime number the sqrt will be a decimal so there will be a little loss of data and would be an underestimate
            if(num%i == 0){//if any number is divisible stop 
                return false;
            }
        }
        return true;
    }

    //quesiton 6: Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
    public static void bigDiff(long target){
        long square = 0;
        long sum = 0;
        for(int i =1;  i<=target; i++){
            sum += i*i;
            square += i;
        }
        System.out.println("the sum is: " + sum);
        square = square * square;
        System.out.println("the square is: " + square);

        System.out.println("The difference is " + (square - sum));
    }

    //question 5:What is the smallest positive number that is evenly divisible by all of the numbers from  1 to 20?
    //I think i might be able to set up a system that essentially is just the numbers that are prime times the largest numbers made of other numbers. 
    //this essentially is something like 2*3=6 this means that I don't need to mult the number that I'm going to make by 2 and three bc they are accounted for by 6
    public static long smallMult(){
        //return 1*7*4*9*10;
        //return 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19*20; 
        //idea:reduce all other numbers by the multiple
        // for(int i = 10 ; i>0; i--){
        //     for(int j = 0; j<i; j++){
        //         if(i%j == 0){

        //         }
        //     }
        // }
        //I could just try to cheat this 
        long target = 1;
        boolean cont = true;
        while(cont){
            if(target%2 == 0 && 
            target%3 == 0 && 
            target%3 == 0 && 
            target%4 == 0 && 
            target%5 == 0 && 
            target%6 == 0 && 
            target%7 == 0 && 
            target%8 == 0 && 
            target%9 == 0 && 
            target%10 == 0 &&
            target%11 == 0 && 
            target%12 == 0 && 
            target%13 == 0 && 
            target%14 == 0 && 
            target%15 == 0 && 
            target%16 == 0 && 
            target%17 == 0 && 
            target%18 == 0 && 
            target%19 == 0 && 
            target%20 == 0){
                System.out.println("This is the target" + target);
                return target;
            }
            target++;
        }
        return -1;
    }

    //question 4:Find the largest palindrome made from the product of two 3-digit numbers.
    // 999 * 999 = 998001 : prolly cant brute force and check all numbers if theyre palidromes
    //idea:use the idea that the largest number is six digits or less and just use 997 then mirror it and subtract one from the end number
    //the issue is really just how many numbers can my computer check
    public static void tacoCat(){
        //going to do a hashmap of all values so that once i find a palindrome i can just submit
        HashSet<Integer> valid = new HashSet<>();
        for(int i = 100; i < 1000; i++){
            for(int j = 100; j < 1000; j++){
                valid.add(i*j);
            }
        }
        String hold = "";
        String num = "";
        boolean cont = true;
        //simple way to get palindromes
        for(int i = 998; i>0; i--){
            hold = num = ""+i;
            //this is the reversing and adding to the og number
            while(cont){
                num += hold.substring(hold.length()-1);
                hold = hold.substring(0, hold.length()-1);
                cont = hold.length() > 0;
            }
            //System.out.println("this is the final result: " + num);
            if(valid.contains(Integer.parseInt(num))){
                System.out.println("palin is "+ num);
                i=-1;
            }
                cont = true;
        }

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
