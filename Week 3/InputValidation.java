import java.util.Scanner;
public class InputValidation {
    private static Scanner input = new Scanner(System.in);
    public static int bookCategoryValidation(){
    Book book = new Book(null, null, false, null, null);
        while (true) {
            try {
                int index = input.nextInt() - 1; input.nextLine();
                if (index >= 0 && index < book.getCategories().length) {
                    return index;
                } else {
                    System.out.print("Invalid category. Try again >> ");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        }
    }
    public static boolean bookStatusValidation(){
        System.out.println("[A] Available || [B] Unavailable"); 
        char choice;
        do {
            System.out.print("Enter book status >> "); choice = input.next().toUpperCase().charAt(0); input.nextLine();
        } while (choice != 'A' && choice != 'B');
        if (choice == 'A') {return true;} else {return false;}
    }
}