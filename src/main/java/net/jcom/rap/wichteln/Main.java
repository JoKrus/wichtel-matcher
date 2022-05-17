package net.jcom.rap.wichteln;

import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        var participantsString = ResourceLoader.readResourceAsList("participantsTEST1.txt", Charset.defaultCharset());
        var participants = participantsString.stream().map(s -> {
            var split = s.split(";");
            return new Participant(split[0], split[1]);
        }).toList();

        var mailerStrings = ResourceLoader.readResourceAsList("mailerconfig.txt", Charset.defaultCharset());

        var mailerConfigWrapper = new MailerConfigWrapper(mailerStrings.get(0), Integer.parseInt(mailerStrings.get(1)),
                mailerStrings.get(2), mailerStrings.get(3), mailerStrings.get(4));

        var mailer = MailerBuilder.withSMTPServer(mailerConfigWrapper.host(), mailerConfigWrapper.port(),
                        mailerConfigWrapper.mail(),
                        mailerConfigWrapper.password())
                .withTransportStrategy(TransportStrategy.SMTP_TLS).buildMailer();

        for (var part : participants) {
            var mail = EmailBuilder.startingBlank().to(part.name(), part.mailAddress())
                    .withSubject("WichtelTestMail").withPlainText("Einfach Parsa man").from(mailerConfigWrapper.name(),
                            mailerConfigWrapper.mail())
                    .buildEmail();

            mailer.sendMail(mail);

            System.out.printf("Mail sent to %s%n", part.name());
        }
    }
}