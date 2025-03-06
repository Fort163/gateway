package com.quick.recording.gateway.config;

import com.quick.recording.gateway.Constant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
@Log4j2
@RequiredArgsConstructor
public class LocaleInterceptor implements RequestInterceptor {

    @Value("${gateway.locale.enabled:true}")
    private Boolean enabled;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (enabled) {
            requestTemplate.header(HttpHeaders.COOKIE,
                        String.format("%s=%s",Constant.LOCALE_COOKIE_NAME, LocaleContextHolder.getLocale()
                    )
            );
        }
    }


}
