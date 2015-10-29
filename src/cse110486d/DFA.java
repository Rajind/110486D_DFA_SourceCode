package cse110486d;

/**
 *
 * @author Rajind
 */
public class DFA {
    Node root;
    
    char arr[] = {'S', 'R', 'G', 'M', 'P', 'D', 'N'};
    
    public DFA(){
        root = new Node('S', false);    //setting root node
        this.initialSetup();
    }
    
    private void initialSetup(){        //setting up DFA
        this.constructDFA("SRGMPDN");
        this.constructDFA("SRGMPDn");
        this.constructDFA("SRGmPDN");
        this.constructDFA("SRgMPDn");
        this.constructDFA("SRgMPdn");
        this.constructDFA("SrGMPdN");
        this.constructDFA("SrGmPDN");
        this.constructDFA("SrGmPdN");
        this.constructDFA("SrgMPdN");
        this.constructDFA("SrgmPdN");
    }
    
    /**
     * Creates DFA tree structure
     * @param str 
     */
    private void constructDFA(String str){
        Node temp = null;
        temp = root;
        int count = 1;
        char c;
        
        while(count < str.length()){
            c = str.charAt(count);
            //System.out.format("Character: %c\n",c);
            if(c == arr[count]){
                //neutral
                if(temp.neutral != null){
                    temp = temp.neutral;
                }else{
                    if(count == 6){
                        //final state
                        temp.neutral = new Node(arr[count], true);
                        temp = temp.neutral;
                    }else{
                        temp.neutral = new Node(arr[count], false);
                        temp = temp.neutral;
                    }
                }
            }else if(c == Character.toLowerCase(arr[count])){
                //flatOrSharp
                if(temp.flatOrSharp != null){
                    temp = temp.flatOrSharp;
                }else{
                    if(count == 6){
                        //final state
                        temp.flatOrSharp = new Node(Character.toLowerCase(arr[count]), true);
                        temp = temp.flatOrSharp;
                    }else{
                        temp.flatOrSharp = new Node(Character.toLowerCase(arr[count]), false);
                        temp = temp.flatOrSharp;
                    }
                }
            }else{
                break;
            }
            count++;
        }
    }
    
    /**
     * Checks the input with tree structure
     * @param str
     * @return 
     */
    public boolean checkString(String str){
        Node temp = root;
        int count = 1;
        char character;
        
        while(count < str.length()){
            character = str.charAt(count);
            //System.out.format("C %c\n",character);
            if(character == arr[count]){
                if(temp != null){
                    temp = temp.neutral;
                }else{
                    break;
                }
            }else if(character == Character.toLowerCase(arr[count])){
                if(temp != null){
                    temp = temp.flatOrSharp;
                }else{
                    break;
                }
            }else{
                temp = null;
                break;
            }
            count++;
        }
        
        if(temp != null){
            if(temp.isAccept()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    /*public static void main(String Args[]){
        DFA dfa =  new DFA();
        
        if(dfa.checkString("SrgMPdN")){
            System.out.println("Accept");
        }else{
            System.out.println("Reject");
        }
    }*/
}
