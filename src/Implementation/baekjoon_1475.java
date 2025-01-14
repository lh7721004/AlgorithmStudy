package Implementation;
import java.util.*;
import java.lang.*;
import java.io.*;
// 방 번호
// https://www.acmicpc.net/problem/1475
public class baekjoon_1475 {
    public static void main(String[] args) throws IOException{
        int cnt = 0;
        int[] numbers = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int strlen = number.length();

        while(cnt<strlen){
            int N = (int)number.charAt(cnt)-48;
            if(N%10==6){
                numbers[9]++;
            }
            else{
                numbers[N%10]++;
            }
            cnt++;
        }
        int max = 0;
        for (int i=0;i<9;i++) {
            max = Math.max(max,numbers[i]);
        }
        int nine = numbers[9]/2;
        if(numbers[9]%2==1)
            nine++;
        max = Math.max(max,nine);
        System.out.print(max);

    }
}