import org.apache.commons.mail.*;

public class EmailWithAttachment {
    public static void main(String[] args) throws EmailException{
        /*
         * // Create the attachment EmailAttachment attachment = new
         * EmailAttachment();
         * attachment.setPath("/home/neila/workspace/SendEmail/test_attachment.gif"
         * ); attachment.setDisposition(EmailAttachment.ATTACHMENT);
         * attachment.setDescription("Test gif attachment");
         * attachment.setName("Kosta");
         * 
         * // Create the email message MultiPartEmail email = new
         * MultiPartEmail(); email.setHostName("mail.gmail.com");
         * email.setAuthenticator(new
         * DefaultAuthenticator("kosta.the.turtle@gmail.com", "Iloveshrimps"));
         * email.setSSLOnConnect(true); email.setDebug(true); try {
         * email.addTo("kosta.the.turtle@gmail.com", "Kosta"); } catch
         * (EmailException e) { e.getCause(); } try {
         * email.setFrom("kosta.the.turtle@gmail.com", "Kosta"); } catch
         * (EmailException e) { e.getCause(); }
         * email.setSubject("The attachment"); try {
         * email.setMsg("Shrimps everywhere"); } catch (EmailException e) {
         * e.getCause(); }
         * 
         * // add the attachment try { email.attach(attachment); } catch
         * (EmailException e) { e.getCause(); }
         * 
         * // send the email try { email.send(); } catch (EmailException e) {
         * e.getCause(); }
         */

        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("kosta.the.turtle@gmail.com", "Iloveshrimps"));
        email.setSSLOnConnect(true);
        email.setFrom("kosta.the.turtle@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("kosta.the.turtle@gmail.com");
        email.send();

    }
}
