/**
 ** Java Program Test Realm
 **/
 
public class Project3TestRealm
{
    public static void main (String[] args) 
    {
    String A = "ACCGGTCGACTGCGCGGAAGCCGGCCGAA";
    String B = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
//    System.out.println(Dyn(A, B));
    int n = 4;
    for (int i = 0; i < n; i++)
    {
    int j = i+1;  
    while (j != n)
    {
    System.out.println(i + " " + j);
    j++;
    }
    }
    }
      
      
public static String Rec(String a, String b){
    int aLen = a.length();
    int bLen = b.length();
    if(aLen == 0 || bLen == 0){
        return "";
    }else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
        return Rec(a.substring(0,aLen-1),b.substring(0,bLen-1))
            + a.charAt(aLen-1);
    }else{
        String x = Rec(a, b.substring(0,bLen-1));
        String y = Rec(a.substring(0,aLen-1), b);
        return (x.length() > y.length()) ? x : y;
    }
}

public static String Dyn(String a, String b) {
    int[][] lengths = new int[a.length()+1][b.length()+1];
 
    // row 0 and column 0 are initialized to 0 already
 
    for (int i = 0; i < a.length(); i++)
        for (int j = 0; j < b.length(); j++)
            if (a.charAt(i) == b.charAt(j))
                lengths[i+1][j+1] = lengths[i][j] + 1;
            else
                lengths[i+1][j+1] =
                    Math.max(lengths[i+1][j], lengths[i][j+1]);
 
    // read the substring out from the matrix
    StringBuffer sb = new StringBuffer();
    for (int x = a.length(), y = b.length();
         x != 0 && y != 0; ) {
        if (lengths[x][y] == lengths[x-1][y])
            x--;
        else if (lengths[x][y] == lengths[x][y-1])
            y--;
        else {
            assert a.charAt(x-1) == b.charAt(y-1);
            sb.append(a.charAt(x-1));
            x--;
            y--;
        }
    }
 
    return sb.reverse().toString();
}
public static int getLongestCommonSubsequence(String a, String b){
 int m = a.length();
 int n = b.length();
 int[][] dp = new int[m+1][n+1];
 
 for(int i=0; i<=m; i++){
  for(int j=0; j<=n; j++){
   if(i==0 || j==0){
    dp[i][j]=0;
   }else if(a.charAt(i-1)==b.charAt(j-1)){
    dp[i][j] = 1 + dp[i-1][j-1];
   }else{
    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
   }
  }
 }
 
 return dp[m][n];
}
}