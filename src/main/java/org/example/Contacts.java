package org.example;

import java.util.Scanner;
import java.util.logging.*;

class Node{
    public Node next = null;
    public String Name;
    public long Phone;
    public String Email;

    public Node(String nm, long ph, String eid){
        setDetails(nm, ph, eid);
    }
    void setDetails(String nm, long ph, String eid) {
        Name = nm;
        Phone = ph;
        Email = eid;
    }
}
public class Contacts{
    Node head;
    int size;
    Logger l = Logger.getLogger("com.api.jar");
    Contacts(){
        head = null;
        size = 0;
    }
    void add(String nm, long ph, String eid){
        Node node = new Node(nm, ph, eid);
        Node current;
        if(head == null){
            head = node;
        }
        else{
            current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }
    void insert(String nm, long ph, String eid, int index){
        Node node = new Node(nm, ph, eid);
        Node current
        Node prev = null;
        if(index == 0){
            current = node;
            current.next = head;
            head = current;
        }
        else if(index > 0){
            current = head;
            for (int i =0; i<index; i++){
                prev = current;
                current = current.next;
            }
            node.next = current;
            prev.next = node;
        }
        size++;
    }
    void remove(int index){
        Node current = head;
        Node prev = null;
        if(index == 0){
            head = current.next;
        }
        else if (index > 0) {
            for(int i = 0; i<index; i++){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
        size--;
    }
    void search(String nm){
        Node current = head;
        StringBuilder search = new StringBuilder();
        int flag = 0;
        while (current != null){
            if(current.Name .equals(nm))
                search.append( current.Name + " " + current.Phone + " " + current.Email + " ");
                flag++;
            current = current.next;
        }
        if(flag != 0) {
            l.info("Your Search Contact is Found...");
            StringBuilder finalSearch = search;
            l.log(Level.INFO,()-> String.valueOf(finalSearch));
        }
        else {
            l.info("Your Search Contact is Not Found...");
        }
    }
    void print(){
        Node current = head;
        StringBuilder str = new StringBuilder();
        while (current != null){
            str.append(current.Name + " " + current.Phone + " " + current.Email + " ");
            current = current.next;
        }
        StringBuilder finalStr = str;
        l.log(Level.INFO,()-> String.valueOf(finalStr));
    }
    public static void main(String[] args) {
        Contacts c = new Contacts();
        Scanner s = new Scanner(System.in);
        Logger l1 = Logger.getLogger("com.api.jar");
        c.add("NITHISH", 9597512667L, "nithish@gmail.com");
        c.add("MANI", 4930872348L, "mani@gmail.com");
        c.add("KANNAN", 8238940349L, "kannan@gmail.com");
        c.print();
        c.insert("KUMAR", 8912749192L, "kumar@gmail.com", 0);
        c.print();
        c.remove(2);
        l1.info("Enter the Search Contact Name:");
        String find = s.nextLine();
        c.search(find);
    }
}
