import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String [] arr1 = new String[str1.length()];
        String [] arr2 = new String[str2.length()];
        int index = 0;
        for(int i = 0; i<str1.length();i=i+1){
            arr1[index++] = str1.substring(i,Math.min(i+2,str1.length()));
        }
        index = 0;
        for(int i = 0; i<str2.length();i=i+1){
            arr2[index++] = str2.substring(i,Math.min(i+2,str2.length()));
        }
        arr1 = Arrays.copyOf(arr1,arr1.length-1);
        arr2 = Arrays.copyOf(arr2,arr2.length-1);
        
        for(int i =0 ; i<arr1.length;i++){
            if(97>(int)arr1[i].charAt(0)||(int)arr1[i].charAt(0)>122){
               arr1[i] = "**"; 
            }else if(97>(int)arr1[i].charAt(1)||(int)arr1[i].charAt(1)>122){
               arr1[i] = "**"; 
            }
        }
        
        for(int i =0 ; i<arr2.length;i++){
            if(97>(int)arr2[i].charAt(0)||(int)arr2[i].charAt(0)>122){
               arr2[i] = "**"; 
            }else if(97>(int)arr2[i].charAt(1)||(int)arr2[i].charAt(1)>122){
               arr2[i] = "**"; 
            }
        }
        Map<String,Integer> map1 = new HashMap<>();
        for(int i = 0; i<arr1.length;i++){
            if(!map1.containsKey(arr1[i])){
                map1.put(arr1[i],1);    
            }else{
                map1.put(arr1[i],map1.get(arr1[i])+1);
            }
        }
        Map<String,Integer> map2 = new HashMap<>();
        for(int i = 0; i<arr2.length;i++){
            if(!map2.containsKey(arr2[i])){
                map2.put(arr2[i],1);    
            }else{
                map2.put(arr2[i],map2.get(arr2[i])+1);
            }
        }
        int N = 0;
        int U = 0;
        Set<String> set1 = map1.keySet();
        Set<String> set2 = map2.keySet();
        //합집합 구하기
        Set<String> unionset = new HashSet<>();
        for(String i : set1){
            unionset.add(i);
        }
        for(String i : set2){
            unionset.add(i);
        }
        //System.out.println(unionset.toString());
        for(String i : unionset){
            int one = 0;
            int two = 0;
            if(i.equals("**")){
                continue;
            }
            if(map1.containsKey(i)){
                one = map1.get(i);
            }
            if(map2.containsKey(i)){
                two = map2.get(i);
            }
            U += Math.max(one,two);
        }
        //교집합 구하기
        for(String i : unionset){
            int one = 0;
            int two = 0;
            if(i.equals("**")){
                continue;
            }
            if(map1.containsKey(i)){
                one = map1.get(i);
            }
            if(map2.containsKey(i)){
                two = map2.get(i);
            }
            N += Math.min(one,two);
            //System.out.println(i+" "+one+" "+two+" "+N+" "+U);
        }
        double J = 0;
        if(N==0&&U==0){
            J = 1;
        }else{
            J = ((double)N)/U;
        }
        return (int)(J*65536);
    }
}