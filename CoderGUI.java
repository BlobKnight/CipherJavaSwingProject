import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.Component;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class CoderGUI extends JFrame {
  private Codable myCoder;
  public CoderGUI() {
    //Window stuff
    this.setSize(800,600);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    //Setting up plain text area
    JTextArea plain = new JTextArea();
    plain.setPreferredSize(new Dimension(290,350));
    plain.setLineWrap(true);
    Border blackline = BorderFactory.createLineBorder(Color.black);
    TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Plain Text");
    titledBorder.setTitleJustification(TitledBorder.CENTER);
    plain.setBorder(titledBorder);
    this.add(plain, BorderLayout.WEST);

    //Setting up cipher text area
    JTextArea cipher = new JTextArea();
    cipher.setPreferredSize(new Dimension(290,500));
    cipher.setLineWrap(true);
    titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Cipher Text");
    titledBorder.setTitleJustification(TitledBorder.CENTER);
    cipher.setBorder(titledBorder);
    this.add(cipher, BorderLayout.EAST);

    //Cipher Buttons
    JPanel cipherButtons = new JPanel();
    cipherButtons.setPreferredSize(new Dimension(800,50));
    cipherButtons.setLayout(new BoxLayout(cipherButtons,BoxLayout.X_AXIS));
    JButton Caesar = new JButton("Caesar Cipher");
    JButton Substitution = new JButton("Substitution Cipher");
    JButton Heffley = new JButton("Heffley Cipher");
    cipherButtons.add(Box.createHorizontalGlue());
    cipherButtons.add(Caesar);
    cipherButtons.add(Box.createHorizontalGlue());
    cipherButtons.add(Substitution);
    cipherButtons.add(Box.createHorizontalGlue());
    cipherButtons.add(Heffley);
    cipherButtons.add(Box.createHorizontalGlue());
    this.add(cipherButtons,BorderLayout.NORTH);

    //Encode and Decode Buttons
    JPanel coderButtons = new JPanel();
    coderButtons.setPreferredSize(new Dimension(800,50));
    coderButtons.setLayout(new BoxLayout(coderButtons,BoxLayout.X_AXIS));
    JButton encode = new JButton("Encode");
    JButton decode = new JButton("Decode");
    coderButtons.add(Box.createHorizontalGlue());
    coderButtons.add(encode);
    coderButtons.add(Box.createHorizontalGlue());
    coderButtons.add(decode);
    coderButtons.add(Box.createHorizontalGlue());
    this.add(coderButtons,BorderLayout.SOUTH);

    JTextArea space = new JTextArea(" "); 
    space.setEditable(false);
    space.setOpaque(false);

    //Card Layout 
    CardLayout cl = new CardLayout();
    JPanel cards = new JPanel(cl);

    JPanel home = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;

    gbc.anchor = GridBagConstraints.PAGE_START;
    JLabel label = new JLabel("<html><bodystyle=font-weight:5px;><h1>Cipher Tool</h1></body></html>");
    home.add(label, gbc);
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    label = new JLabel("<html><bodystyle=font-weight:5px;><p>     By Shubham Bhatnagar</p></body></html>");
    home.add(label, gbc);
    gbc.gridy = 2;

    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    //subgbc.anchor = GridBagConstraints.PAGE_START;
    JTextArea desc = new JTextArea("Use the above buttons to select the cipher, and click encode or decode after following the instructions of each cipher. Input plain text on the left pane, and input cipher text on the right pane. Click the Encode and Decode buttons accordingly. The Caesar and the Substitution require additional user input in the form of shifts and key, respectively. Have fun!");
    desc.setColumns(3);
    gbc.weightx = 1;
    gbc.weighty = 1;
    desc.setEditable(false);
    desc.setLineWrap(true);
    desc.setWrapStyleWord(true);
    desc.setOpaque(false);
    home.add(desc, gbc);
    gbc.gridy = 3;
    //JTextArea subKey = new JTextArea("Enter Key Here");
    cards.add(home,"HOME");


    JPanel heffleyPage = new JPanel(new GridBagLayout());
    GridBagConstraints heffgbc = new GridBagConstraints();
    heffgbc.gridx = 0;
    heffgbc.gridy = 0;
    heffgbc.anchor = GridBagConstraints.PAGE_START;
    label = new JLabel("<html><bodystyle=font-weight:5px;><p>Heffley Cipher</p></body></html>");
    heffleyPage.add(label, heffgbc);
    heffgbc.gridy = 1;
    heffleyPage.add(space, heffgbc);
    heffgbc.gridy = 2;
    heffgbc.anchor = GridBagConstraints.FIRST_LINE_START;
    heffgbc.fill = GridBagConstraints.HORIZONTAL;
    //subgbc.anchor = GridBagConstraints.PAGE_START;
    desc = new JTextArea("This cipher needs no key. It was created by Jeff Kinney in his famous book series 'Diary of a Wimpy Kid', with the main character Greg Heffley. In the second book 'Roderick Rules', Greg invents this cipher and makes fun of his friend's dad, who unfortunately saw through the cipher. After almost every word, a '-pa' is added after. There must be only one space in between words.");
    desc.setColumns(3);
    heffgbc.weightx = 1;
    heffgbc.weighty = 1;
    desc.setEditable(false);
    desc.setLineWrap(true);
    desc.setWrapStyleWord(true);
    desc.setOpaque(false);
    heffleyPage.add(desc, heffgbc);
   


    cards.add(heffleyPage,"HEFFLEY");

    JPanel substitutionPage = new JPanel(new GridBagLayout());
    GridBagConstraints subgbc = new GridBagConstraints();
    subgbc.gridx = 0;
    subgbc.gridy = 0;
    subgbc.anchor = GridBagConstraints.PAGE_START;
    label = new JLabel("<html><bodystyle=font-weight:5px;><p>Substitution Cipher</p></body></html>");
    substitutionPage.add(label, subgbc);
    subgbc.gridy = 1;
    substitutionPage.add(space, subgbc);
    subgbc.gridy = 2;
    subgbc.anchor = GridBagConstraints.FIRST_LINE_START;
    subgbc.fill = GridBagConstraints.HORIZONTAL;
    //subgbc.anchor = GridBagConstraints.PAGE_START;
    desc = new JTextArea("The Substitution takes a key with every single letter of the alphabet, with no duplicates. This is how it knows what to swap each letter with. No duplicates are allowed, and the string must be exactly 26 characters. The nth letter of the alphabet is replaced with the nth letter of the key.");
    desc.setColumns(3);
    subgbc.weightx = 1;
    subgbc.weighty = 1;
    desc.setEditable(false);
    desc.setLineWrap(true);
    desc.setWrapStyleWord(true);
    desc.setOpaque(false);
    substitutionPage.add(desc, subgbc);
    subgbc.gridy = 3;
    JTextArea subKey = new JTextArea("Enter Key Here");
    subKey.setLineWrap(true);
    substitutionPage.add(subKey, subgbc);
    subgbc.gridy = 4;
    JButton randomize = new JButton("Randomize Key");
    substitutionPage.add(randomize, subgbc);
    cards.add(substitutionPage,"SUBSTITUTION");








    JPanel caesarPage = new JPanel(new GridBagLayout());
    GridBagConstraints cgbc = new GridBagConstraints();
    cgbc.gridx = 0;
    cgbc.gridy = 0;
    cgbc.anchor = GridBagConstraints.PAGE_START;
    label = new JLabel("<html><bodystyle=font-weight:5px;><p>Caesar Cipher</p></body></html>");
    caesarPage.add(label, cgbc);
    cgbc.gridy = 1;
    caesarPage.add(space, cgbc);
    cgbc.gridy = 2;
    cgbc.anchor = GridBagConstraints.FIRST_LINE_START;
    cgbc.fill = GridBagConstraints.HORIZONTAL;
    //subgbc.anchor = GridBagConstraints.PAGE_START;
    desc = new JTextArea("The Caesar Cipher takes a shift number, and shifts each character down that amount in the alphabet. For example, A would become C if the shift amount was set to 2. This is a very old and very popular cipher, though not very secure. Use the spinner below to select the shift.");
    desc.setColumns(3);
    cgbc.weightx = 1;
    cgbc.weighty = 1;
    desc.setEditable(false);
    desc.setLineWrap(true);
    desc.setWrapStyleWord(true);
    desc.setOpaque(false);
    caesarPage.add(desc, cgbc);
    cgbc.gridy = 3;
    SpinnerNumberModel shiftModel = new SpinnerNumberModel(1,0,25,1);    
    JSpinner shift = new JSpinner(shiftModel);
    shift.setEditor(new JSpinner.DefaultEditor(shift));
    caesarPage.add(shift, cgbc);
    cards.add(caesarPage,"CAESAR");

    this.add(cards,BorderLayout.CENTER);






    //Reactions
    Caesar.addActionListener( e-> {
      cl.show(cards,"CAESAR");
      myCoder = new CaesarCipher(0);
    }); 
    Heffley.addActionListener( e-> {
      cl.show(cards,"HEFFLEY");
      myCoder = new HeffleyCipher();
    });
    Substitution.addActionListener( e-> {
      cl.show(cards,"SUBSTITUTION");
      myCoder = new SubstitutionCipher("");
    });

    encode.addActionListener( e-> {
      if (myCoder instanceof CaesarCipher) {
        int shiftValue = (Integer) shift.getValue();
        myCoder = new CaesarCipher(shiftValue);
        String cipherText = myCoder.encode(plain.getText());
        cipher.setText(cipherText);
      } else if (myCoder instanceof SubstitutionCipher) {
        //System.out.println(subKey.getText());  
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] test = subKey.getText().toCharArray();
        Arrays.sort(test);
        if (Arrays.equals(test,alphabet)) {
          myCoder = new SubstitutionCipher(subKey.getText());
          String cipherText = myCoder.encode(plain.getText());
          cipher.setText(cipherText);
        } else {
          JOptionPane.showMessageDialog(null, "String must be all lowercase, be 26 characters long, and contain every letter of the alphabet.","Incorrect Syntax" , JOptionPane.ERROR_MESSAGE);
        }

      } else if (myCoder instanceof HeffleyCipher) {
        char[] heffTest = (plain.getText()).toCharArray();
        boolean check = true;
        for (int i = 0; i < heffTest.length-1; i++) {
          if (heffTest[i] == ' ' && heffTest[i+1] == ' ') {
            check = false;
          }
        }
        if (check == false) {
          JOptionPane.showMessageDialog(null, "String must have no more than one space separating words.","Incorrect Syntax" , JOptionPane.ERROR_MESSAGE);
        } else {
          String cipherText = myCoder.encode(plain.getText());
          cipher.setText(cipherText);
        }
        
      } else {
        JOptionPane.showMessageDialog(null, "Select a cipher using the buttons on the top before encoding.","No Cipher Selected" , JOptionPane.ERROR_MESSAGE);
      }
      //myCoder.encode();
    });

    decode.addActionListener( e-> { 
      if (myCoder instanceof CaesarCipher) {
        int shiftValue = (Integer) shift.getValue();
        myCoder = new CaesarCipher(shiftValue);
        String plainText = myCoder.decode(cipher.getText());
        plain.setText(plainText);
      } else if (myCoder instanceof SubstitutionCipher) {
        //System.out.println(subKey.getText());  
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] test = subKey.getText().toCharArray();
        Arrays.sort(test);
        if (Arrays.equals(test,alphabet)) {
          myCoder = new SubstitutionCipher(subKey.getText());
          String plainText = myCoder.decode(cipher.getText());
          plain.setText(plainText);
        } else {
          JOptionPane.showMessageDialog(null, "String must be all lowercase, be 26 characters long, and contain every letter of the alphabet.","Incorrect Syntax" , JOptionPane.ERROR_MESSAGE);
        }

      } else if (myCoder instanceof HeffleyCipher) {
        char[] heffTest = (cipher.getText()).toCharArray();
        boolean check = true;
        for (int i = 0; i < heffTest.length-1; i++) {
          if (heffTest[i] == ' ' && heffTest[i+1] == ' ') {
            check = false;
          }
        }
        if (check == false) {
          JOptionPane.showMessageDialog(null, "String must have no more than one space separating words.","Incorrect Syntax" , JOptionPane.ERROR_MESSAGE);
        } else {
          String plainText = myCoder.decode(cipher.getText());
          plain.setText(plainText);
        }



      } else {
        JOptionPane.showMessageDialog(null, "Select a cipher using the buttons on the top before decoding.","No Cipher Selected" , JOptionPane.ERROR_MESSAGE);
      }
      //myCoder.encode();
    });

     randomize.addActionListener( e-> {
       char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
       String randomKey = "";

       List<String> defaultKey = new ArrayList<>(
            List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
       for (int i = 0; i < 26; i++) {
         int index = ((int) (Math.random()*((26-(i+1))-0+1)+0));
         randomKey += defaultKey.get(index);
         defaultKey.remove(index);
       }

       subKey.setText(randomKey);
    }); 

    

  }
    


  
}