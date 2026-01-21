package vlume.provider.userPrivider;

import com.fasterxml.jackson.databind.ObjectMapper;
import vlume.models.User;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class UserProvider {
    User user;

    public User createValidUser() throws IOException {

        try {
            File file = new File("src/main/resources/userData/valid_user_data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(file, User.class);
        } catch (IIOException e) {
            e.printStackTrace();
        }
        return user;
    }

}
