package com.web.university.guide.helper;

import com.web.university.guide.service.GuideHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class RestTemplateHelper {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GuideHelper guideHelper;

    public <T> Optional<T> getRequest(Map<String, String> properties, Class<T> clazz) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(guideHelper.getCityByName());
        Set<String> strings = properties.keySet();
        for (String key : strings) {
            builder = builder.queryParam(key, properties.get(key));
        }
        ResponseEntity<T> exchange = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, clazz);
        return exchange.getStatusCode().isError() ? Optional.empty() : Optional.ofNullable(exchange.getBody());
    }

}
