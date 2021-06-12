public class CaesarCipher implements Codable{
  int shift;
  char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  public CaesarCipher(int s) {
    shift = s;
  }
  public String encode(String plainText) {
    String encoded = "";
    for (int i = 0; i < plainText.length(); i++) {  
      char character = Character.toLowerCase(plainText.charAt(i));
      boolean found = false;
      for (int j = 0; j < alphabet.length; j++) {
        if (alphabet[j] == character && found == false) {
          found = true;
          if (j+shift >= 26) {
            encoded += alphabet[(j+shift)-26];
          } else if (j+shift < 0) {
            encoded += alphabet[26-Math.abs(j+shift)];
          } else {
            encoded += alphabet[j+shift];
          }
        }
      }
      if (found == false) {
        encoded += character;
      }
    }
    return(encoded);
    
  }
  public String decode(String codeText) {
    shift = shift*(-1);
    return(encode(codeText));
  }
}