package Implementation;
import java.util.*;
import java.lang.*;
import java.io.*;
// 치킨 배달
// https://www.acmicpc.net/problem/15686
public class baekjoon_15686 {
    static class Node{
        int x;
        int y;
        int chickenstreet;
        boolean closed;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
            this.chickenstreet = Integer.MAX_VALUE;
            this.closed = false;
        }
    }
    static ArrayList<Node> chickenhouses = new ArrayList<Node>();
    static ArrayList<Node> houses = new ArrayList<Node>();
    static int N,M;
    public static int getDistance(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    public static int getChickenStreet(Node home){
        int x = home.x;
        int y = home.y;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<chickenhouses.size();i++){
            Node chickenhouse = chickenhouses.get(i);
            if(chickenhouse.closed==false){
                min = Math.min(min,getDistance(chickenhouse.x,chickenhouse.y,x,y));
            }
        }
        home.chickenstreet = min;
        return min;
    }

    static int comb1(int[] arr, boolean[] visited, int start, int r, int min) {
        if(r == 0) {
            int num = print(arr, visited);
            min = Math.min(min,num);
            return min;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                min = Math.min(min,comb1(arr, visited, i + 1, r - 1,min));
                visited[i] = false;
            }
            return min;
        }
    }


    // 배열 출력
    static int print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            Node chickenhouse = chickenhouses.get(i);
            if(visited[i] == true){
                chickenhouse.closed = true;
            }
        }
        int sum = 0;
        for(int i=0;i<houses.size();i++){
            Node house = houses.get(i);
            sum += getChickenStreet(house);
        }
        for(int i = 0; i < arr.length; i++) {
            Node chickenhouse = chickenhouses.get(i);
            if(visited[i] == true){
                chickenhouse.closed = false;
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        // 2가 치킨집, M개의 치킨집을 살림
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                int value = Integer.parseInt(input[j]);
                Node temp = new Node(i,j);
                if(value==1){//house
                    houses.add(temp);
                }
                else if(value==2){
                    chickenhouses.add(temp);
                }
            }
        }
        int[] arr = new int[chickenhouses.size()];
        int chickenhouseCount = chickenhouses.size();
        for(int i=0;i<chickenhouses.size();i++){
            arr[i] = i;
        }
        boolean[] visited = new boolean[chickenhouses.size()];

        int MinValue = comb1(arr, visited, 0, chickenhouseCount-M,Integer.MAX_VALUE);
        System.out.println(MinValue);
    }
}