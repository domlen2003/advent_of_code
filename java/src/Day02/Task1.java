public class Task1
{
    public static void main(String[] args) 
    {
        new Task1().start(args);
    }

    public void start(String[] args)
    {
        for (String input : args) {
            int from = Integer.parseInt(String.valueOf(input.charAt(0)));
            int to = Integer.parseInt(String.valueOf(input.charAt(2)));
            char character = input.charAt(4);
            String password = input.substring(5, input.length());
            
            long count = password.chars().filter(ch -> ch == character).count();
            if(count<=to && count>=from){
                System.out.print("valid ");
            }
            else{
                System.out.print("invalid ");
            }
            
            System.out.println("From"+from+" to "+to+" times "+character+" I Found "+count+" in "+password);
        }
    }
}
