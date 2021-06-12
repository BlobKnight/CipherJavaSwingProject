
public class SubstitutionCipher implements Codable{
  char[] key;
  char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  public SubstitutionCipher(String k) {
    key = k.toCharArray();
  }
  public String encode(String plainText) {
    String encoded = "";
    for (int i = 0; i < plainText.length(); i++) {
      char character = Character.toLowerCase(plainText.charAt(i));
      boolean found = false;
      for (int j = 0; j < alphabet.length; j++) {
        if (alphabet[j] == character && found == false) {
          encoded = encoded + key[j];
          found = true;
        }
      }
      if (found == false) {
        encoded += character;
      }
    }
    return(encoded);

   
    
  }
  public String decode(String codeText) {
    String decoded = "";
    for (int i = 0; i < codeText.length(); i++) {
      char character = Character.toLowerCase(codeText.charAt(i));
      boolean found = false;
      for (int j = 0; j < key.length; j++) {
        if (key[j] == character && found == false) {
          decoded = decoded + alphabet[j];
          found = true;
        }
      }
      if (found == false) {
        decoded += character;
      }
    }
    return(decoded);
    
  }
}