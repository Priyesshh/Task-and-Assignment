import java.util.InputMismatchException;
import java.util.Scanner;


interface PaymentProvider {
    void processPayment(double amount, PaymentMethod method);
}


class Paytm implements PaymentProvider {
    
    public void processPayment(double amount, PaymentMethod method) {
        System.out.println("Intializing" + amount + " INR through Paytm using " + method.getType());
        method.collectDetails();
        System.out.println("Payment of "+ amount + "  successfull through Paytm!");
    }
}

class AmazonPay implements PaymentProvider {
    
    public void processPayment(double amount, PaymentMethod method) {
        System.out.println("Intializing" + amount + " INR through Amazon Pay using " + method.getType());
        method.collectDetails();
        System.out.println("Payment of "+ amount + "  successfull through Amazon Pay!");
    }
}

class PhonePe implements PaymentProvider {
    
    public void processPayment(double amount, PaymentMethod method) {
        System.out.println("Intializing" + amount + " INR through PhonePe using " + method.getType());
        method.collectDetails();
        System.out.println("Payment of "+ amount + "  successfull through PhonePe!");
    }
}


interface PayDetail {
    void collectDetails();
}


abstract class PaymentMethod {
    private String type;
    private PayDetail detailsCollector;

    public PaymentMethod(String type, PayDetail detailsCollector) {
        this.type = type;
        this.detailsCollector = detailsCollector;
    }

    public String getType() {
        return type;
    }

    public void collectDetails() {
        detailsCollector.collectDetails();
    }
}


class WalletDetails implements PayDetail {
    private String phoneNumber;

    
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while(check)
        {   int cnt = 0;
            System.out.println("please enter a 10 digit phone number");
            this.phoneNumber = scanner.nextLine();
            if(phoneNumber.length()==10)
            {
             for(int i = 0 ; i< phoneNumber.length() ; i++){
                if((phoneNumber.charAt(i)>47 && phoneNumber.charAt(i)<58))
                {
                   cnt++;
                }
                else{
                     cnt--;
                } 
             }
             if(cnt==10){
                check = false;
            }
           
            }
        }
        
    }
}

class Wallet extends PaymentMethod {
    public Wallet() {
        super("Wallet", new WalletDetails());
    }
}

class UPIDetails implements PayDetail {
    private String upiId;

    
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter UPI ID: ");
        this.upiId = scanner.nextLine();
    }
}

class UPI extends PaymentMethod {
    public UPI() {
        super("UPI", new UPIDetails());
    }
}

class CardDetails implements PayDetail {
    private String cardNumber;
    private String expiry;
    private String cvv;

    
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Card Number: ");
        this.cardNumber = scanner.nextLine();
        if(cardNumber.length()!=16){
             System.out.println("Your Card number is invalid, Please restart the process");
             System.exit(1);
        }
      
        System.out.print("Enter Expiry (MM/YY): ");
        this.expiry = scanner.nextLine();
        
        System.out.print("Enter CVV: ");
        this.cvv = scanner.nextLine();
        if(cvv.length()!=3){
             System.out.println("Your Card cvv is invalid, Please restart the process");
             System.exit(1);
        }
    }
}

class Card extends PaymentMethod {
    public Card(String type) {
        super(type, new CardDetails());
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount;

        while (true) {
            try {
                System.out.print("Enter amount: ");
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    throw new IllegalArgumentException("Amount must be positive.");
                }
                break; // Exit the loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Choose payment provider:");
        System.out.println("Press 1 for Paytm");
        System.out.println("Press 2 for Amazon Pay");
        System.out.println("Press 3 for PhonePe");

        int providerChoice = scanner.nextInt();
        PaymentProvider provider = null;

        switch (providerChoice) {
            case 1:
                provider = new Paytm();
                break;
            case 2:
                provider = new AmazonPay();
                break;
            case 3:
                provider = new PhonePe();
                break;
            default:
                System.out.println("Please choose from the above options");
                return;
        }

        System.out.println("Choose payment method:");
        System.out.println("Press 1 for Wallet");
        System.out.println("Press 2 for UPI");
        System.out.println("Press 3 for Credit Card");
        System.out.println("Press 4 for Debit Card");

        int methodChoice = scanner.nextInt();
        PaymentMethod method = null;

        switch (methodChoice) {
            case 1:
                method = new Wallet();
                break;
            case 2:
                method = new UPI();
                break;
            case 3:
                method = new Card("Credit Card");
                break;
            case 4:
                method = new Card("Debit card");
                break;
            default:
                System.out.println("Select the option from given methods");
                return;
        }

        if (provider != null && method != null) {
            provider.processPayment(amount, method);
        }
    }
}
