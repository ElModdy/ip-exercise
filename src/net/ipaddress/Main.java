package net.ipaddress;

/**
 * Main class to demonstrate the usage of IndirizzoIP.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- IP Address Manager Demo ---");

        try {
            // Example 1: Create from String
            String ipStr = "192.168.1.10";
            System.out.println("\nCreating IP from string: " + ipStr);
            IndirizzoIP ip1 = new IndirizzoIP(ipStr);
            System.out.println("IP: " + ip1);
            System.out.println("Class: " + ip1.getClasse());
            System.out.println("Network IP: " + ip1.getIndirizzoIPDiRete());

            // Example 2: Create from integers
            System.out.println("\nCreating IP from integers: 192.168.1.25");
            IndirizzoIP ip2 = new IndirizzoIP(192, 168, 1, 25);
            System.out.println("IP2: " + ip2);
            
            // Check same network
            boolean sameNetwork = ip1.appartieneAllaStessaRete(ip2);
            System.out.println("Are " + ip1 + " and " + ip2 + " in the same network? " + sameNetwork);

            // Example 3: Different network
            IndirizzoIP ip3 = new IndirizzoIP("10.0.0.1");
            System.out.println("\nComparing with " + ip3);
            System.out.println("Are " + ip1 + " and " + ip3 + " in the same network? " + ip1.appartieneAllaStessaRete(ip3));

            // Example 4: Random IP
            System.out.println("\nGenerating random IP...");
            IndirizzoIP randomIP = IndirizzoIP.generaIndirizzoIPCasuale();
            System.out.println("Random IP: " + randomIP);
            System.out.println("Class: " + randomIP.getClasse());

        } catch (NotValidIPAddressException e) {
            System.err.println("Error: Invalid IP address format.");
            e.printStackTrace();
        }
    }
}
