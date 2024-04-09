import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import java.io.*;
import java.util.Properties;

public class AwsSecretsManagerIntegration{

    private static final String CONFIG_FILE_PATH = "configuration.properties";
    private static final String SECRET_KEY_PLACEHOLDER = "user_name";

    public static void main(String[] args) {
        // Run your application, fetch secret from AWS Secrets Manager, and call updateConfiguration
        try {
            String secretValue = getSecret();
            updateConfiguration(SECRET_KEY_PLACEHOLDER, secretValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getSecret() {
        String secretName = "user_name";
        Region region = Region.of("us-east-1");

        // Create a Secrets Manager client
        try (SecretsManagerClient client = SecretsManagerClient.builder().region(region).build()) {
            GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            GetSecretValueResponse getSecretValueResponse = client.getSecretValue(getSecretValueRequest);

            // Assuming the secret is stored as a string
            return getSecretValueResponse.secretString();
        } catch (Exception e) {
            // Handle exceptions accordingly
            throw new RuntimeException("Failed to retrieve secret from AWS Secrets Manager.", e);
        }
    }

    private static void updateConfiguration(String placeholder, String value) throws IOException {
        // Load the properties from the file
        Properties properties = loadProperties();

        // Update the property with the actual secret value
        properties.setProperty(placeholder, value);

        // Save the updated properties back to the file
        saveProperties(properties);
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
        }
        return properties;
    }

    private static void saveProperties(Properties properties) throws IOException {
        try (OutputStream output = new FileOutputStream(CONFIG_FILE_PATH)) {
            properties.store(output, "Updated by AwsSecretsManagerIntegration");
        }
    }
}
