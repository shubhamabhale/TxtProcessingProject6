package project6;

public class LCS {
	public int findJ(int[] l1, int[] l2, int n) {
		int m = 0;
		int j = 0;

		for(int i=0; i<=n; i++) {	
			if(m < (l1[i]+l2[n-i])) 
			{
				m = l1[i]+l2[n-i];
				j = i;
			}
		}

		return j;
	}

	public int[] algorithmB(int m, int n, String a, String b) {
		int[][] K = new int[2][n+1];
		for( int j=0; j<=n; j++) {
			K[1][j] = 0;
		}
		for(int i=1; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				K[0][j] = K[1][j];
			}
			for(int j=1; j<=n; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					K[1][j] = K[0][j-1] + 1;
				}else{
					K[1][j] = max(K[1][j-1], K[0][j]);
				}
			}
		}
		return K[1];

	}
	public String find(String a, String b) {
		// Implement the Hirschberg LCS algorithm 
		int m = a.length();
		int n = b.length();

		String answer = "";
		if( n==0 ) {
			answer = "";
		} else if( m==1 ) {
			answer = "";
			for( int i=0; i<n; i++ ) {
				if( a.charAt(0)==b.charAt(i) ) {
					answer= ""+a.charAt(0);
					break;
				}
			}
		} else {
			int i= (int) Math.floor(((double)m)/2);
			int[] l1 = algorithmB(i, n, a.substring(0,i), b);
			int[] l2 = algorithmB(m-i, n, reverseStr(a.substring(i)), reverseStr(b));
			int j = findJ(l1, l2, n);
			String ans1 = find(a.substring(0, i), b.substring(0, j));
			String ans2 = find(a.substring(i), b.substring(j));
			answer = ans1+ans2;
		}

		return answer; 

	}
	public String reverseStr(String str) {
		String ans = "";

		for(int i=str.length()-1; i>=0; i--) {
			ans = ans+str.charAt(i);
		}

		return ans;
	}
	public int max(int a, int b) {
		if(a>b) {
			return a;
		}else{
			return b;
		}
	}

}
