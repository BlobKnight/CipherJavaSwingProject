import java.util.Arrays;
public class HeffleyCipher implements Codable{
  
  public HeffleyCipher() {
  }
  public String encode(String plainText) {
    String encoded = "";
    String[] plainArray = plainText.split(" ");
    for (int i = 0; i < plainArray.length; i++) {
      if (plainArray[i].equals("a") || plainArray[i].equals("an") || plainArray[i].equals("i") || plainArray[i].equals(" ") || plainArray[i].equals(""))
      {
        continue;
      } else {
        plainArray[i]+="-pa";
        if (plainArray[i].equals("-pa")) {
          plainArray[i] = "";
        }
      }
    }

    for (int i = 0; i < plainArray.length-1; i++) {
      encoded += plainArray[i];
      encoded += " ";
    }
    encoded += plainArray[plainArray.length-1];

    return(encoded);
  }


  public String decode(String codeText) {
    String decoded = "";
    String[] cipherArray = codeText.split(" ");
    for (int i = 0; i < cipherArray.length; i++) {
      char[] paCheck = cipherArray[i].toCharArray();
      if (cipherArray[i].length() < 4) {
        continue;
      }
      if (paCheck[paCheck.length-1] == 'a' && paCheck[paCheck.length-2] == 'p' && paCheck[paCheck.length-3] == '-') {
        char[] minusPa = Arrays.copyOfRange(paCheck, 0, paCheck.length-3);
        String removed = "";
        for (char k: minusPa) {
          removed += k;
        }
        cipherArray[i] = removed;
      }  
    }
    for (int i = 0; i < cipherArray.length; i++) {
        decoded += cipherArray[i];
        decoded += " ";
    }
  return(decoded);
  }
}