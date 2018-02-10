import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
public static void main(String[] arc ){
Scanner scanner=new Scanner(System.in);
String w=scanner.nextLine();
ArrayList<String> lines=new ArrayList<>();
try (BufferedReader br = new BufferedReader(new FileReader("ws.txt"))) {
String line;
long count=0;
while ((line = br.readLine()) != null) {
lines.add(line);
long c=Long.parseLong(line.replaceAll("\\s+"," ").split(" ")[1]);
count=count+c;
}
System.out.println(count);
for (String line1:lines){

String word=line1.replaceAll("\\s+"," ").split(" ")[0];
long c=Long.parseLong(line1.replaceAll("\\s+"," ").split(" ")[1]);
if (minDistance(w,word)<=3){
double d=(double) c/(double) count;
System.out.println(word+" "+d);

}
}
} catch (IOException e) {
e.printStackTrace();
}

}
public static int minDistance(String word1, String word2) {
int len1 = word1.length();
int len2 = word2.length();


int[][] dp = new int[len1 + 1][len2 + 1];

for (int i = 0; i <= len1; i++) {
dp[i][0] = i;
}

for (int j = 0; j <= len2; j++) {
dp[0][j] = j;
}

for (int i = 0; i < len1; i++) {
char c1 = word1.charAt(i);
for (int j = 0; j < len2; j++) {
char c2 = word2.charAt(j);

if (c1 == c2) {
//update dp value for +1 length
dp[i + 1][j + 1] = dp[i][j];
} else {
int replace = dp[i][j] + 1;
int insert = dp[i][j + 1] + 1;
int delete = dp[i + 1][j] + 1;

int min = replace > insert ? insert : replace;
min = delete > min ? min : delete;
dp[i + 1][j + 1] = min;
}
}
}

return dp[len1][len2];
}
}