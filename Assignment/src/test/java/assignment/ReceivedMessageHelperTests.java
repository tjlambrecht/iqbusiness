package assignment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iqbusiness.helpers.ReceivedMessageHelper;

public class ReceivedMessageHelperTests {
	ReceivedMessageHelper receivedMessageHelper;
	
    @BeforeEach                                         
    void setUp() {
    	receivedMessageHelper = new ReceivedMessageHelper();
    }
    
    @Test
    void getNameFromMessage_whenValidMessage_thenName() {
    	var name = receivedMessageHelper.getNameFromMessage("Hello my name is, Luke");
        assertTrue(name.equals("Luke"));
    }

    @Test
    void getNameFromMessage_whenInvalidMessage_thenNull() {
    	var name = receivedMessageHelper.getNameFromMessage("Hello my name is Luke");
        assertTrue(name == null);
    }

    @Test
    void generateResponseFromName_whenValidName_thenResponse() {
    	var response = receivedMessageHelper.generateResponseFromName("Luke");
        assertTrue(response.equals("Hello Luke, I am your father!"));
    }
}
