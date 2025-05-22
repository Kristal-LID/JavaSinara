package com.urfu.homework.web;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {

    @PostMapping("/post")
    public Request getRequestWithId(@RequestBody Request request) {
        long newId = getUniqueId();

        if (newId == 1) {
            throw new BadGateway("error %s"
                    .formatted(request.toString()));
        }

        request.getInfo().setId(getUniqueId());
        return request;
    }


    private long getUniqueId() {
        return 1L;
    }
}
