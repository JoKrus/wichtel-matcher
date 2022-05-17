package net.jcom.rap.wichteln;

import org.apache.commons.lang3.tuple.Pair;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public class MailOutput implements OutputStrategy {
    private final MailerConfigWrapper mailerConfigWrapper;
    private final Mailer mailer;

    public MailOutput() {
        var mailerStrings = ResourceLoader.readResourceAsList("mailerconfig.txt", Charset.defaultCharset());

        var mailerConfigWrapper = new MailerConfigWrapper(mailerStrings.get(0), Integer.parseInt(mailerStrings.get(1)),
                mailerStrings.get(2), mailerStrings.get(3), mailerStrings.get(4));

        var mailer = MailerBuilder.withSMTPServer(mailerConfigWrapper.host(), mailerConfigWrapper.port(),
                        mailerConfigWrapper.mail(),
                        mailerConfigWrapper.password())
                .withTransportStrategy(TransportStrategy.SMTP_TLS).buildMailer();

        this.mailerConfigWrapper = mailerConfigWrapper;
        this.mailer = mailer;
    }

    @Override
    public void writeOutput(List<Pair<Participant, Participant>> matches) {
        //Shuffle list of matches here again to obfuscate the order of matches since the algorithm now produces
        //predictable matches based on the order of apperance

        Collections.shuffle(matches);

        for (var match : matches) {
            var part = match.getLeft();
            var opponent = match.getRight();

            var mail = EmailBuilder.startingBlank().to(part.name(), part.mailAddress())
                    .withSubject("Wichteln 2022 - Dein Gegner ist ...").withPlainText("Einfach %s man".formatted(opponent.name()))
                    .from(mailerConfigWrapper.name(), mailerConfigWrapper.mail())
                    .buildEmail();

            mailer.sendMail(mail);

            System.out.printf("Mail sent to %s%n", part.name());
        }
    }
}
