package assignment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iqbusiness.helpers.SendMessageHelper;

public class SendMessageHelperTests {
	SendMessageHelper sendMessageHelper;
	
    @BeforeEach                                         
    void setUp() {
    	sendMessageHelper = new SendMessageHelper();
    }
    
    @Test
    void generateMessageFromName_whenValidName_thenMessage() {
    	var message = sendMessageHelper.generateMessageFromName("Luke");
        assertTrue(message.equals("Hello my name is, Luke"));
    }
}
