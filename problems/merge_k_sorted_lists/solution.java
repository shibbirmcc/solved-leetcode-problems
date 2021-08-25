import java.util.*;
import java.util.Map.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        TreeSet<Integer> sortedData = new TreeSet<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        
        for(ListNode node : lists){
            while(node != null){
                frequency.merge(node.val, 1, Integer::sum);
                sortedData.add(node.val);
                node = node.next;
            }
        }
        
        if(sortedData.isEmpty()){
            return null;
        }
        
        Integer data = sortedData.pollFirst();
        Integer freq = frequency.remove(data) - 1;
        ListNode result = new ListNode(data);
        ListNode root = result;
        while(freq > 0){
            root.next = new ListNode(data);
            root = root.next; 
            freq--;
        }
        
        while(!sortedData.isEmpty()){
            data = sortedData.pollFirst();
            freq = frequency.remove(data);
            while(freq > 0){
                root.next = new ListNode(data);
                root = root.next; 
                freq--;
            }
        }
        return result;
    }
}