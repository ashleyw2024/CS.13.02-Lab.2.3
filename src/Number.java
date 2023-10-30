import java.util.ArrayList;

public class Number {
  private int denary;
  
  public Number(int denary) {
    this.denary = denary;
  }

  public int getDenary() {
    return denary;
  }

  public void setDenary(int denary) {
    this.denary = denary;
  }

  public String getSignedBinary() {
    if(this.denary == 0 || this.denary == 1) {
      return String.valueOf(this.denary);
    }
    boolean isNegative = false;
    int copyDenary = this.denary;
    if(this.denary < 0) {
      isNegative = true;
      copyDenary *= -1; 
    }
    // convert the number into binary
    StringBuilder result = new StringBuilder();
    while(copyDenary > 0) {
      int rem = copyDenary % 2;
      result.append((char) (48 + rem));
      copyDenary = copyDenary / 2;
    }
    StringBuilder result2 = new StringBuilder();
    result2.append(result);
    result2.reverse();
    result = new StringBuilder(result2);
    if(!isNegative) {
      return "0" + result;
    }

    // two's complement
    // first perform one's complement
    // flip 0s to 1s and 1s to 0s
    char[] binaryChar = result.toString().toCharArray();
    for(int j = 0; j < binaryChar.length; j++) {
      if(binaryChar[j] == '1') {
        binaryChar[j] = '0';
      }
      else {
        binaryChar[j] = '1';
      }
    }

    // adding 1 to make it a two's complement
    for(int j = binaryChar.length - 1; j >= 0; j--) {
      if(binaryChar[j] == '1') {
        binaryChar[j] = '0';
      }
      else {
        binaryChar[j] = '1';
        break;
      }
    }
    return "1" + String.copyValueOf(binaryChar);
//    return " ";
  }
  
  private int binaryToDec(String binary) {
    int numOfBinaryDigits = binary.length();
    int result = 0;
    for(int i = numOfBinaryDigits - 1, j = 0; i >= 0; i--, j++) {
      result += (int) ((binary.charAt(j) - 48) * Math.pow(2, i));
    }
    return result;
  }

  public String getHexadecimal() {
    char[] hexaChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    String binary = this.getSignedBinary();
    // 100010011
    if(binary.charAt(0) == '0') {
      binary = binary.substring(1);
    }
    int lengthBinary = binary.length();
    String result = "";
    String reverseBinary = new StringBuilder(binary).reverse().toString();
    for(int i = 0; i < lengthBinary; i = i + 4) {
      int endIndex = (int)Math.min(lengthBinary, i + 4);
      String chunk = new StringBuilder(reverseBinary.substring(i, endIndex)).reverse().toString();
      int decimalChunk = this.binaryToDec(chunk);
      result = hexaChars[decimalChunk] + result;
    }
    return result;
  }

  public void negate() {
    this.denary *= -1;
  }
  @Override
  public String toString() {
    // "Number{denary=148 binary=010010100 hexadecimal=94}"
    return "Number{denary=" + this.getDenary() + " binary=" + this.getSignedBinary() + " hexadecimal=" + this.getHexadecimal() + "}";
  }
}
