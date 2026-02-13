# IP Address Manager

A simple Java library and application for managing IPv4 addresses. This project provides functionality to create, validate, and manipulate IPv4 addresses, including determining network classes and calculating network addresses.

## Project Structure

The source code is organized in the `net.ipaddress` package:

-   `IndirizzoIP.java`: The core class representing an IPv4 address. It handles:
    -   Parsing IP addresses from Strings or integers.
    -   Validating IP address bytes (0-255).
    -   Determining the Network Class (A, B, C, D, E).
    -   Generating random IP addresses.
    -   Calculating the Network IP address based on the class.
    -   Checking if two IPs belong to the same network.
-   `NotValidIPAddressException.java`: A custom exception thrown when an invalid IP address is encountered.
-   `Main.java`: A demonstration class showing how to use the library.

## Prerequisites

-   Java Development Kit (JDK) 8 or higher.
-   (Optional) Apache Ant or NetBeans IDE for building with the provided project files.

## Compilation and Running

### Using Command Line (Manual)

You can compile and run the project manually using `javac` and `java`.

1.  **Compile the source code:**

    ```bash
    mkdir -p bin
    javac -d bin src/net/ipaddress/*.java
    ```

2.  **Run the application:**

    ```bash
    java -cp bin net.ipaddress.Main
    ```

    You should see output demonstrating the creation and manipulation of IP addresses.

### Using NetBeans or Ant

This project was originally created as a NetBeans project. If you have Apache Ant installed, you can build and run it using:

```bash
ant run
```

Or open the project in NetBeans IDE and run it from there.

## Usage Example

Here is a snippet showing how to use the `IndirizzoIP` class:

```java
import net.ipaddress.IndirizzoIP;
import net.ipaddress.NotValidIPAddressException;

public class Example {
    public static void main(String[] args) {
        try {
            // Create an IP address
            IndirizzoIP ip = new IndirizzoIP("192.168.1.10");
            
            // Get the class
            System.out.println("Class: " + ip.getClasse()); // Output: C
            
            // Get the network address
            System.out.println("Network: " + ip.getIndirizzoIPDiRete()); // Output: 192.168.1.0
            
            // Check if two IPs are in the same network
            IndirizzoIP otherIp = new IndirizzoIP("192.168.1.55");
            if (ip.appartieneAllaStessaRete(otherIp)) {
                System.out.println("Same network!");
            }
            
        } catch (NotValidIPAddressException e) {
            e.printStackTrace();
        }
    }
}
```

## Dependencies

-   The project includes `libs/algs4.jar`, but it is currently not used by the main logic.
