import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Challenges {
    public static void main(String[] args){

    }
    //სავარჯიშო 1
    public static boolean isPalindrome(String text){
        StringBuilder sb = new StringBuilder(text).reverse();
        String reversedText = sb.toString();
        return text.equals(reversedText);
    }


    //სავარჯიშო 2
    public static Integer minSplit(int amount){
        int count = 0;
        while(amount/50>0){
            amount -= 50;
            count += 1;
        }
        while(amount/20>0){
            amount -= 20;
            count += 1;
        }
        while(amount/10>0){
            amount -= 10;
            count += 1;
        }
        while(amount/5>0){
            amount -= 5;
            count += 1;
        }
        while(amount/1>0){
            amount -= 1;
            count += 1;
        }
        return count;
    }
    //სავარჯიშო 3
    public static Integer notContains(Integer [] array){
        int x = 1;
        for(Integer each: array){
            if(each==x)
                x+=1;
        }
        return x;
    }
    //სავარჯიშო 4
    public static boolean isProperly(String sequence){
        ArrayList<Character> charlist = new ArrayList<Character>();
        String se = sequence.replaceAll("()","");
        ArrayList<String> brackets = new ArrayList<String>();
        brackets.add("(");
        brackets.add(")");
        for(Character each: se.toCharArray()){
            if(brackets.contains(each.toString()))
                charlist.add(each);
        }
        int amount1 = count(se,"(");
        int amount2 = count(se,")");
        if(charlist.size()%2==0){
            if(amount1==amount2){
                if (charlist.get(0).toString().equals("(") && charlist.get(charlist.size() - 1).toString().equals(")"))
                    return true;
            }
        }
        return false;

    }

    public static Integer count(String text,String symbol){
        int amount = 0;
        for(Character each: text.toCharArray()){
            if(each.toString() == symbol )
                amount++;
        }
        return amount;

    }

    //სავარჯიშო 5
    public static Integer countVariants(int stearsCount){
        if(stearsCount <= 2)
            return stearsCount;
        else
            return countVariants(stearsCount-1) + countVariants(stearsCount-2);
    }


    //სავარჯიშო 6
    static class MyDS{
        ArrayList<Integer> arr;
        HashMap<Integer, Integer> hash;


        public MyDS(){
            arr = new ArrayList<Integer>();
            hash = new HashMap<Integer, Integer>();
        }

        void add(int x){
            if (hash.get(x) != null)
                return;
            int s = arr.size();
            arr.add(x);
            hash.put(x, s);
        }

        void remove(int x){
            Integer index = hash.get(x);
            if (index == null)
                return;
            hash.remove(x);
            int size = arr.size();
            Integer last = arr.get(size-1);
            Collections.swap(arr, index,  size-1);
            arr.remove(size-1);
            hash.put(last, index);
        }

    }

}
