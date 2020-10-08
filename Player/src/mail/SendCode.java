package mail;

public class SendCode {
	public void send(String email, String cod) {
		SendMail sendMail = new SendMail("smtp.gmail.com", "465", "TODO email", "TODO senha", "ssl");
		sendMail.send("isabelaw15@hotmail.com", email, "Confirmando Email","Seu codigo de confirmação:\n\t" + cod);
	}
}
