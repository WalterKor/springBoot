package com.cos.security.config;

import com.cos.security.oauth.PricipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //활성화시키는거 스프링시큐리티 필터가 스프링필터체인에 등록이된다.
//prePostEnabled = true preAuthorize, postAuthorize 어노테이션 활성화
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true) //secured어노테이션활성화
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PricipalOauth2UserService pricipalOauth2UserService;

    //해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
   @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
             //user 403에러가뜬다 접근 권한이 없다
            .antMatchers("/user/**").authenticated() //인증만되면 들어 갈 수 있는 페이지
            .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .anyRequest().permitAll()//위에 세가지가 아니면 누구나 들어 갈  수 있다고 설정함 로그인페이지가 비활성화
            //로그인페이지로 이동시키는거
            .and()
            .formLogin()
            .loginPage("/loginForm")
            //.usernameParameter("username2")
            .loginProcessingUrl("/login") //login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인을 진행하게 해준다.
            .defaultSuccessUrl("/") //로그인에 성공하게되면 /주소로 이동하게한다.
            .and()
            .oauth2Login()
            .loginPage("/loginForm") //구글로그인이 완료된 후처리가 필요한데
                //1.코드받기(인증) 2.엑세스토큰(권한) 3.사용자프로필 정보를 가져오고
                //4. 그 정보를 토대로 회원가입을 자동으로 진행시키기도한다.
                //4. 쇼핑몰 => 집주소, 고객의 등급 Tip : 구글로그인이 되면 (엑세스토큰 + 사용자프로필정보(0)) 한방에 받아진다.
            .userInfoEndpoint()
            .userService(pricipalOauth2UserService);

    }
}
