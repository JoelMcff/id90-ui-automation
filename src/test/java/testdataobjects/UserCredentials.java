package testdataobjects;

import lombok.Data;
import utils.ConvertJson;

import static utils.CollectionOfConstants.USER_CREDENTIALS_FILE_PATH;

@Data
public class UserCredentials {

    private String validUsername;
    private String validPassword;
    private String company;

    public static UserCredentials getData() {
        return ConvertJson.fromPath(USER_CREDENTIALS_FILE_PATH).toObject(UserCredentials.class);
    }
}
