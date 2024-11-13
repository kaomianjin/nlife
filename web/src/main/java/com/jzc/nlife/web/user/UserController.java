package com.jzc.nlife.web.user;

import com.google.gson.Gson;
import com.jzc.nlife.common.entity.normal.R;
import com.jzc.nlife.web.entity.UserRequest;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Resource
    private Gson gson;

    @PostMapping("login")
    public R<String> login(@RequestBody UserRequest dto){

        log.info(gson.toJson(dto));
        return R.okResult("登录成功");
    }
}
