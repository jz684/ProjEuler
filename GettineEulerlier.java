public class GettineEulerlier {
    public static void main (String[] args){
        long input = 20L ;//600851475143L
        System.out.println(primeTime(input));
    }

    //question 3
    public static long primeTime(long target){
        //looking back at this the prime number cant be more than half so you dont actually need to start at the number
        //still needs to be a bit faster so gonna try looking for factors instead because there is realistically less of them
        boolean checker = false;
        for(long i = target; i > 0; i--){//this is for factor checking
            
            if((target/i)*i == target && target/i % 2 != 1 ){//this is to actually check if it's a factor and if it's even. If its even it can't be a prime number
                //prime checking
                
                for(long j = i; j < target/2+1; j++){
                    
                    if(((double)i)/j == i/j && j!=i){//if the number is prime
                        checker = false;
                        
                    }
                    
                }
                if(checker){
                    System.out.println("harro");
                    return i;

                }   
            }

        }
        
        // boolean checker = false;
        // long temp = target;
        // if(target%2== 0){//will always make it odd
        //     temp--;
        // }
        // for(long i = temp; i>1; i-=2){//each number
        //     for(long j = temp; j>1; j--){
        //         if(((double)i)/j == i/j){//if the number is prime
        //             checker = false;
        //         }
        //         if(j == i){
        //             checker = true;
        //         }
                
        //     }
        //     if(checker){
        //         //System.out.println("a prime number is "+i);
        //         temp = target/2;
        //         if((temp/i)*i == target){//if it's a factor
        //             System.out.println("a prime factor is "+i);
        //             return i;
        //         }
        //     }
        // }


        return -1111111111;//if its this number i goofed
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
