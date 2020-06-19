package com.example.demo.config.messages;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import net.rakugakibox.util.YamlResourceBundle;

@Configuration
public class MessagesConfiguration {
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREA);
		return resolver;
	}
	
	@Bean
	public MessageSource messageSource(@Value("${spring.messages.basename}") String basename
			, @Value("${spring.messages.encoding}") String encoding
			, @Value("${spring.messages.fallback-to-system-locale}") boolean fallbackToLocale) {
	
		YamlMessageSource ms = new YamlMessageSource();
		ms.setBasename(basename);
		ms.setDefaultEncoding(encoding);
		ms.setFallbackToSystemLocale(fallbackToLocale);
		ms.setAlwaysUseMessageFormat(true);
		ms.setUseCodeAsDefaultMessage(true);
		
		return ms;
	}
	
	class YamlMessageSource extends ResourceBundleMessageSource{
		@Override
		protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
			return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
		}
	}
	
}
