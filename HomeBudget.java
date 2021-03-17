import java.util.Scanner;
abstract class Homebudget  //an abstract class of HomeBudget
{     
static Scanner s = new Scanner(System.in);    
static double rent;    
static double movies,incomeJob;    
static double income()   //method to calculate total Income
{
double anyOther,totalIncome;      
System.out.println("Calculate your monthly income first");      
System.out.print("Enter your income by job: ");
incomeJob= s.nextDouble();
System.out.print("Enter income from other sources: ");
anyOther= s.nextDouble(); 
totalIncome = incomeJob+anyOther;      
return totalIncome;
}     
static double essentialOutgoing()   //for calculating total essential expenses
{
double totalEssentialOutgoing, travel, insurance, utilityBills, food;   
System.out.println("\nDomestic Expenses");       
System.out.print(" ");       
System.out.print("Rent to pay: ");  
rent = s.nextDouble();       
System.out.print("Insurance Charges: ");
insurance =s.nextDouble();    
System.out.print("DailyUtility(Gas/LPG): "); 
utilityBills = s.nextDouble(); 
System.out.print("Travel: ");      
travel = s.nextDouble(); 
System.out.print("Groceries(per week): ");  
food = s.nextDouble();       
totalEssentialOutgoing = rent + travel +  food + utilityBills + insurance;   
return totalEssentialOutgoing;   
 }  
static double fun()   //for calculating the expenses for fun and entertainment
 {        
 double totalFun, clothing, restaurant;      
 System.out.println("Fun and Enjoy: ");       
 System.out.print(" "); 
 System.out.print("Expense on clothing: ");      
 clothing = s.nextDouble();       
 System.out.print("Expense on Movies: ");   
 movies = s.nextDouble();     
System.out.print("Expense on Restaurant: ");   
 restaurant = s.nextDouble();    
 totalFun = movies + clothing+ restaurant;        
 return totalFun;
}     
public static void main(String[] args)
{
double theTotalIncome=0, theTotalEssentialOutgoing, theTotalOtherCosts,AvailOther,saved, MoneyAvail;   

// We are printing each texts with a delay using Threads.
String text = "Welcome to Home Budget Management.....";
char[] charArr = text.toCharArray();
for(int i=0; i<=charArr.length-1;i++)
    {
        System.out.print(charArr[i]);
        try 
        {
            Thread.sleep(100); 
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
  } 
System.out.println("\nLet's calculate your monthly expenditure:");           
theTotalIncome = income();       
System.out.println("Your income for the month is Rs." + theTotalIncome); 
System.out.println("\nYour ideal expenses for this month should be: ");
System.out.println("|------------------------------------------------------|");
System.out.println("|Domestic Essentials(Cylinder,food,travel etc)| "+(theTotalIncome*0.6)+"|\n|Other costs(clothing,movies,restaurant etc)  | "+(theTotalIncome*0.3)+"|\n|Your saving this month should be             |  "+(theTotalIncome*0.1)+"|");      
System.out.println("|------------------------------------------------------|");
MoneyAvail= theTotalIncome*0.9;       
System.out.println("You have Rs." + MoneyAvail + " to spend");     
theTotalEssentialOutgoing = essentialOutgoing();     
System.out.println("You have spent Rs." + theTotalEssentialOutgoing);   
AvailOther = MoneyAvail-theTotalEssentialOutgoing;    

// Now,if the some money left after essential expenses then we can have money left for fun and entertainment else we cant spend and loop will exit
if(AvailOther>=0) { 
System.out.println("\nMoney available for Fun And Enjoy is Rs."+AvailOther);
System.out.println("|------------------------------------|");
System.out.println("|Amt available for Movies    | "+(AvailOther*0.3)+"|\n|Amt available for Clothing  | "+(AvailOther*0.5)+"|\n|Amt available for restaurant| "+(AvailOther*0.2)+"|");
System.out.println("|------------------------------------|");
theTotalOtherCosts = fun();     
System.out.println("You have spent Rs." + theTotalOtherCosts + " for fun and enjoyments.");
saved = AvailOther - theTotalOtherCosts;

// After all expenses, we have saved any money then it will be our Monthly Saving else loop will exit.    
if(saved>=0){ 
System.out.println("Congrats!! This month you have saved a total of Rs."+(saved+(MoneyAvail*0.1))); }
else{
System.out.println("You have exceeded your limit by Rs."+(-saved)); }
}
else{
System.out.println("You have exceeded your budget by Rs." +(-AvailOther)) ;
System.out.println("SORRY, You have spent all in Essential, no money left for fun"); }
}
}