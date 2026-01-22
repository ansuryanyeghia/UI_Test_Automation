package provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class UserProvider {
    User user;

    public User createValidUser() throws IOException {

        try {
            File file = new File("src/main/resources/data/valid_user_data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(file, User.class);
        } catch (IIOException e) {
            e.printStackTrace();
        }
        return user;
    }

}
