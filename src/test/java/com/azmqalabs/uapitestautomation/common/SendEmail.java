package com.azmqalabs.uapitestautomation.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;

public class SendEmail {
	// supply your SMTP host name
	private static String host = "host";

	// supply a static sendTo list
	private static String to = "recipient@host.com";

	// supply the sender email
	private static String from = "sender@host.com";

	// default cc list
	private static String cc = "";

	// default bcc list
	private static String bcc = "";

	public static void send(String from, String to, String subject, String contents) throws MessagingException {
		Properties prop = System.getProperties();
		prop.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(prop);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setSubject(subject);
		message.setContent(contents, "text/html");

		Transport.send(message);
	}

	public static void send(String to, String subject, String contents) throws MessagingException {
		send(from, to, subject, contents);
	}

	public static void send(String subject, String contents) throws MessagingException {
		send(from, to, subject, contents);
	}

	private static List getAddress(String address) {
		List addressList = new ArrayList();

		if (address.isEmpty())
			return addressList;

		if (address.indexOf(";") > 0) {
			String[] addresses = address.split(";");

			for (String a : addresses) {
				addressList.add(a);
			}
		} else {
			addressList.add(address);
		}

		return addressList;
	}
}
