// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.ipmessaging.v1.service.channel.Member;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACCOUNT_SID";
  public static final String AUTH_TOKEN = "AUTH_TOKEN";
  public static final String SERVICE_SID = "SERVICE_SID";
  public static final String CHANNEL_SID = "CHANNEL_SID";

  public static void main(String[] args) {
    // Initialize the client
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    // Retrieve the list of members on that channel
    ResourceSet<Member> members = Member.reader(SERVICE_SID, CHANNEL_SID).read();

    for (Member member : members) {
      System.out.println(member.getIdentity());
    }
  }
}
