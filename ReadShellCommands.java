import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Sample {
  
  public static void main(String args[]) {
    
    try {
      Process process = Runtime.getRuntime().exec("ls -l");

      StringBuilder output = new StringBuilder();

      BufferedReader reader = new BufferedReader( new InputStreamReader ( process.getInputStream()));

      String line;

      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }

      int exitVal = process.waitFor();
      if (exitVal == 0) {
        System.out.println("Success");
        System.out.println(output);
        System.exit(0);
      } else {
        System.out.println("Something abnormal has happened");
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}