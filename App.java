import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static Map<String, Double> conv;

    static 
    {
        conv = new HashMap<>();
        conv.put("kg_to_lb", 2.20462);
        conv.put("gram_to_ounces", 0.03527396);
        conv.put("km_to_mile", 0.621371);
        conv.put("mm_to_inch", 0.0393701);
    }

    public static double convert(double value, String conversion)
    {
        return value * conv.get(conversion);
    }

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to metric converter!");
        System.out.println("Your conversion options are, kg to lb, gram to ounces, km to mile, and mm to inch");
        System.out.println("Please input your query. For example, '1 km to mile'");
        System.out.println("Enter 'exit' to exit the program.");

        while (true) 
        {
            String inpt = scan.nextLine().toLowerCase();

            if (inpt.equals("exit")) 
                break;

            try 
            {
                String[] inptArry = inpt.split("\\s+");
                double convValue = Double.parseDouble(inptArry[0]);
                String conv = inptArry[1] + "_to_" + inptArry[3];

                double result = convert(convValue, conv);
                System.out.printf("%.3f %s = %.3f %s%n", convValue, inptArry[1], result, inptArry[3]);
            } 
            catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) 
            {
                System.out.println("Please try again, for example, 1 km to m");
            }
        }
        scan.close();
    }
}