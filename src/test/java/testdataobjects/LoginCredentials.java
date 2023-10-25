package testdataobjects;

import lombok.Data;
import utils.ConvertJson;

import static utils.CollectionOfConstants.LOGIN_CREDENTIALS_FILE_PATH;

/**
 * Java object class responsible for storing the data read from the json file indicated in the path e.g. LOGIN_CREDENTIALS_FILE_PATH
 */
@Data
public class LoginCredentials {

    private String company;
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    public static LoginCredentials getData() {
        return ConvertJson.fromPath(LOGIN_CREDENTIALS_FILE_PATH).toObject(LoginCredentials.class);
    }
}
