package Market;

import java.util.LinkedList;
import java.util.Scanner;

public class User {
    private String password;
    private String login;
    private Basket my_basket;
    User(String login, String password) {
        this.my_basket = new Basket();
        this.login = login;
        this.password = password;
        System.out.println("User created");
    }
    public boolean check_login(String login) {
        if (this.login == login) return true;
        else return false;
    }
    public boolean check_password(String password) {
        if (this.password == password) return true;
        else return false;
    }
    public void change_password(String login, String old_password, String new_password) {
        if (check_login(login) & check_password(old_password)){
            this.password = new_password;
            System.out.println("Password changed");}
        else System.out.println("Try again");
    }
    public void add_to_basket(Product new_item) {
        my_basket.add_new(new_item);
        my_basket.get_out_my_basket();
    }
    public void get_items_from_basket() {
        my_basket.get_out_my_basket();
    }

    public void delete_item_from_my_basket(int index) {
        my_basket.delete_item_from_basket(index);
        my_basket.get_out_my_basket();
    }


    class Basket {
        private LinkedList<Product> basket;

        Basket() {
        }

        void add_new(Product new_item) {
            basket.add(new_item);
        }

        void get_out_my_basket() {
            if (basket.size() > 0)
                for (int i = 0; i < basket.size(); i++) {
                    System.out.println("1" + basket.get(i).info());

                }
            else System.out.println("Корзина пуста");
        }

        void delete_item_from_basket(int index) {
            index--;
            if ((basket.size() > index) & (index >= 0)) {
                basket.remove(index);

            }
        }
    }
}