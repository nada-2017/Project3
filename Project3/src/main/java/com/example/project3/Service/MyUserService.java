package com.example.project3.Service;

import com.example.project3.Model.MyUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserService {

    ArrayList<MyUser> myUsers = new ArrayList<>();

    public ArrayList<MyUser> getMyUsers(){
        return myUsers;
    }

    public void addUser(MyUser user){
        myUsers.add(user);
    }

    public boolean updateUser(int id, MyUser user){
        for (int i =0; i < myUsers.size(); i++) {
            if (myUsers.get(i).getId() == id) {
                myUsers.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id){
        for (int i =0; i < myUsers.size(); i++) {
            if (myUsers.get(i).getId() == id) {
                myUsers.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean find(int id){
        for (int i =0; i < myUsers.size(); i++) {
            if (myUsers.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public double deductBalance(int id, double amount){
        for (int i =0; i < myUsers.size(); i++) {
            if (myUsers.get(i).getId() == id) {
                if (myUsers.get(i).getBalance() > amount) {
                    myUsers.get(i).setBalance(myUsers.get(i).getBalance() - amount);
                    return myUsers.get(i).getBalance();
                }
            }
        }
        return -1;
    }
}
