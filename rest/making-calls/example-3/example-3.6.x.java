// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.list.CallList;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Example { 

  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) throws TwilioRestException {
    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

    // Build a filter for the CallList
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("Url", "http://demo.twilio.com/docs/voice.xml"));
    params.add(new BasicNameValuePair("To", "+14155551212"));
    params.add(new BasicNameValuePair("SendDigits", "1234#"));
    params.add(new BasicNameValuePair("From", "+18668675309"));
    params.add(new BasicNameValuePair("Method", "GET"));
    
    
    CallFactory callFactory = client.getAccount().getCallFactory();
    Call call = callFactory.create(params);
    System.out.println(call.getSid());
  }
}