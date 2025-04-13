class Solution {
    // we have 5 possible choice of putting even numbers {0,2,4,6,8} at one plce
// and 4 possible choice of prime numbers {2,3,5,7} at one place
// let for n=5 _ _ _ _ _ at even place we can put any one of 5 even numbers . Number of even place available = (n+1)/2 and
// number of odd place avaiable are n/2 . so the number of outputs are 5*4*5*4*4 - 5^3 * 4^2 

public int countGoodNumbers(long n) 
{
    return (int)((power(5,(n+1)/2) * power(4,n/2)) % 1000000007) ; 
}

long power(long n,long m)
{
    if(m==0)
        return 1; // base case for return 
    // We are using a divide and conquere technique to find the power since it use //O(log n) times to do this. ;
    
    long ans=  power(n,m/2);    // dividing
    
    return ans*ans*((m%2==0)? 1:n) % 1000000007;   // concuring
}
}