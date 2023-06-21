public class LargestDivisibleSubsetDP44 {
    static int f(int arr[]){
        int n=arr.length;
        int dp[]=new int[n];
        int hash[]=new int[n];
        int maxi=1;
        int lastindex=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[prev]<arr[i]) && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastindex=i;
            }
            

            }
        }
    }
    
}
