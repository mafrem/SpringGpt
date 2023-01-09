package fr.mujum.springGpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringGptApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGptApplication.class, args);
	}

	@GetMapping("/run-python-script")
    public String runPythonScript() {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec("python script.py");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

}
