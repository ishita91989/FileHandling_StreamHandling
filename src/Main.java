//import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;

class FileHandlingExample {
    public static void main(String[] args) {
        try {
            // Create a directory named "Demo" in the current working directory
            File directory = new File("Demo");
            if (directory.mkdir()) {
                System.out.println("Directory created: " + directory.getName());
            } else {
                System.out.println("Directory already exists.");
            }

            // Create a text file named "example.txt" inside the "Demo" directory
            File file = new File(directory, "example.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Write some sample text content to the file
            FileWriter writer = new FileWriter(file);
            writer.write("This is some sample text content.");
            writer.close();
            System.out.println("Text content written to the file successfully.");

            // Read the contents of the file and display them on the console
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            System.out.println("Contents of the file:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();

            // Update the content of the file by appending new text
            FileWriter appendWriter = new FileWriter(file, true);
            appendWriter.write("\nThis is some appended text.");
            appendWriter.close();
            System.out.println("Text content appended to the file successfully.");

            // Read the updated contents of the file and display them on the console
            FileReader updatedReader = new FileReader(file);
            BufferedReader updatedBufferedReader = new BufferedReader(updatedReader);

            System.out.println("Updated contents of the file:");
            String updatedLine;
            while ((updatedLine = updatedBufferedReader.readLine()) != null) {
                System.out.println(updatedLine);
            }

            updatedBufferedReader.close();

            // Delete the file "example.txt"
            if (file.delete()) {
                System.out.println("File deleted: " + file.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }

            // Delete the directory "Demo"
            if (directory.delete()) {
                System.out.println("Directory deleted: " + directory.getName());
            } else {
                System.out.println("Failed to delete the directory.");
            }

            // Additional tasks for byte and character stream handling

            // Create a new text file named "byteExample.txt" and write some text using byte streams
            try {
                FileOutputStream byteFileOutputStream = new FileOutputStream("byteExample.txt");
                byte[] byteContent = "This is some text written using byte streams.".getBytes();
                byteFileOutputStream.write(byteContent);
                byteFileOutputStream.close();
                System.out.println("Text content written to byteExample.txt using byte streams.");
            } catch (IOException e) {
                System.out.println("Failed to write to byteExample.txt: " + e.getMessage());
            }

            // Read the contents of "byteExample.txt" using byte streams and display them on the console
            try {
                FileInputStream byteFileInputStream = new FileInputStream("byteExample.txt");
                int byteData;
                System.out.println("Contents of byteExample.txt:");
                while ((byteData = byteFileInputStream.read()) != -1) {
                    System.out.print((char) byteData);
                }
                byteFileInputStream.close();
            } catch (IOException e) {
                System.out.println("Failed to read byteExample.txt: " + e.getMessage());
            }

            System.out.println();

            // Create a new text file named "characterExample.txt" and write some text using character streams
            try {
                FileWriter characterFileWriter = new FileWriter("characterExample.txt");
                characterFileWriter.write("This is some text written using character streams.");
                characterFileWriter.close();
                System.out.println("Text content written to characterExample.txt using character streams.");
            } catch (IOException e) {
                System.out.println("Failed to write to characterExample.txt: " + e.getMessage());
            }

            // Read the contents of "characterExample.txt" using character streams and display them on the console
            try {
                FileReader characterFileReader = new FileReader("characterExample.txt");
                BufferedReader characterBufferedReader = new BufferedReader(characterFileReader);

                System.out.println("Contents of characterExample.txt:");
                String characterLine;
                while ((characterLine = characterBufferedReader.readLine()) != null) {
                    System.out.println(characterLine);
                }

                characterBufferedReader.close();
            } catch (IOException e) {
                System.out.println("Failed to read characterExample.txt: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}