package vttp2022.workshop3;

import java.io.Console;
import java.util.List;

import javax.swing.SortingFocusTraversalPolicy;

//Command program -> Similar to the switch case in workshop 1
public class Session {
    public static final String LIST = "list";
    public static final String CARTS = "carts";
    public static final String ADD = "add";
    public static final String DELETE = "del";
    public static final String LOAD = "load";
    public static final String USERS = "users";
    public static final String SAVE = "save";
    public static final String END = "end";
    public static final String LOGIN = "login";
    
    private Repository repository;
    private Cart currCart;

//Repository keys in the file and stores the file (Basically database)
    public Session(Repository repo){
        this.repository = repo;
    }

    public void start(){
        Console cons = System.console();
        boolean stop = false;
        currCart = new Cart("anon");

        while(!stop){
            String input = cons.readLine("> ");
            String[] terms = input.split(" ");
            switch(terms[0]){
                case CARTS:
                    System.out.println("List of shopping carts");
                    //list carts db files 
                    //TODO
                    break;

                case LIST:
                //Display a message that shows what the current user have in their personal cart
                    System.out.printf("Items in %s's shopping cart \n", currCart.getUsername());
                //When code exceeds 80 characters, it will truncates (At the database centre) 
                    //TODO 
                    printList(currCart.getContents());
                    break;
                
                case ADD:
                    int before = currCart.getContents().size();
                    for(int i =1; i< terms.length; i++)
                        currCart.add(terms[i]);
                    int addedCount = currCart.getContents().size() - before;
                    System.out.printf("Added %d item(s) to %s's cart\n", addedCount, currCart.getUsername());
                    break;
                
                case DELETE:
                    int idx = Integer.parseInt(terms[1]);
                    String item = currCart.delete(idx);
                    System.out.printf("Removed %s from %s's cart", item, currCart.getUsername());
                    break;

                case LOAD:
                    //currCart = repos
                    //TODO
                    break;

                case LOGIN:
                    currCart = new Cart(terms[1]);
                    break;

                case USERS:
                    //TODO 
                    break;
                    
                case SAVE:
                    //TODO
                    break;

                case END:
                    stop = true;
                    break;

                default:
                    System.err.printf("Unknown input : %s\n", terms[0]);
            }
            System.out.println("");
        }
        System.out.println("Thank you for shopping with us!");
    }
    public void printList(List<String> list){
        if (list.size()<=0){
            System.out.println("No records found!");
            return;
        }

        for(int i=0; i<list.size(); i++){
            System.out.printf("%d.%s\n", (i+1), list.get(i));
        }
    }
}
