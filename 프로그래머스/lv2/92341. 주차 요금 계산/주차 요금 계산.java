import java.util.*;
class Solution {
    static String[][] board;
    static Set<String> set = new HashSet<>();
    static List<Node> list = new LinkedList<>();
    public int[] solution(int[] fees, String[] records) {
        board = new String[records.length][3];
        for(int i = 0; i<records.length;i++){
            board[i] = records[i].split(" ");
            set.add(board[i][1]);
        }
        List<String> numbers = new ArrayList<>(set);
        for(int i = 0 ; i<numbers.size();i++){
            String num = numbers.get(i);
            int in = 0;
            int out = 0;
            int time = 0;
            int fee = 0;
            for(int j = 0; j<board.length;j++){
                if(!board[j][1].equals(num)) continue;
                if(board[j][2].equals("IN")){
                    in = transfer(board[j][0]);
                }
                if(board[j][2].equals("OUT")){
                    out = transfer(board[j][0]);
                    time += out - in;
                    out = 0;
                    in = -1;
                }
            }
            if(in!=-1){
                time += 23*60+59-in;
            }
            if(time<fees[0]){
                fee = fees[1];
            }
            if(time>=fees[0]){
                fee = fees[1]+((int)Math.ceil(1.0*(time-fees[0])/fees[2]))*fees[3];
            }
            list.add(new Node(num,fee));
        }
        Collections.sort(list,(a,b)->(Integer.parseInt(a.number)-Integer.parseInt(b.number)));
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            answer[i] = list.get(i).fee;
        }
        return answer;
    }
    static int transfer(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
    }
    class Node{
        String number;
        int fee;
        public Node(String a, int b){
            this.number = a;
            this.fee = b;
        }
    }
}