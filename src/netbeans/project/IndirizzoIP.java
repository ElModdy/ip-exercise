package netbeans.project;

import java.util.Random;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IndirizzoIP {
    
    private static final Map<String,Integer> NETCLASS = new HashMap<String,Integer>(){{
        put("A",1); put("B",2); put("C",3); put("D",0); put("E",0);
    }};
    
    private int [] ipBytes;
    
    public IndirizzoIP() {
        ipBytes = new int[4];
    }
    
    public IndirizzoIP( int a, int b, int c, int d) throws NotValidIPAddressException  {
        this(new int[]{a,b,c,d});
    }
    
    public IndirizzoIP( String ip) throws NotValidIPAddressException{
        this(Stream.of(ip.split("\\."))
                    .mapToInt(Integer::parseInt)
                    .toArray());
    }
    
    public IndirizzoIP( int[] ipBytes ) throws NotValidIPAddressException {
        if(Arrays.stream(ipBytes).anyMatch(b -> b < 0 || b > 255))
            throw new NotValidIPAddressException();
        
        this.ipBytes = ipBytes;
    }
    
    public char getClasse(){
        if(ipBytes[0] < 128)
            return 'A';
        if(ipBytes[0] < 192)
            return 'B';
        if(ipBytes[0] < 224)
            return 'C';
        if(ipBytes[0] < 240)
            return 'D';
        return 'E';
    }
    
    public static IndirizzoIP generaIndirizzoIPCasuale() throws NotValidIPAddressException{
        return new IndirizzoIP(new Random().ints(4, 0, 255)
                                           .toArray());
    }
    
    private int[] getNetwork( int numBytes ){
        return IntStream.concat(Arrays.stream(Arrays.copyOfRange(ipBytes, 0, numBytes)), 
                                Arrays.stream(new int[4-numBytes]))
                        .toArray();
    }
    
    public IndirizzoIP getIndirizzoIPDiRete() throws NotValidIPAddressException{
        return new IndirizzoIP(getNetwork(NETCLASS.get("" + getClasse())));
    }
    
    public boolean appartieneAllaStessaRete(IndirizzoIP ip) throws NotValidIPAddressException{
        return getIndirizzoIPDiRete().equals(ip.getIndirizzoIPDiRete());
    }
    
    public int[] getIpBytes(){
        return ipBytes;
    }
    
    public boolean equals(IndirizzoIP ip){
        return Arrays.equals(ipBytes, ip.getIpBytes());
    }
    
    public String toString(){
        return Arrays.stream(ipBytes).mapToObj(i -> "" + i)
                                     .collect(Collectors.joining("."));
    }
}
