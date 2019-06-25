package kr.whenever.crocodile.security;

import java.util.ArrayList;
import java.util.List;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.common.member.MemberType;
import kr.whenever.crocodile.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberService memberService;
    
    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        // 시스템 사용자조회
    	// TODO 비밀번호에 대한 고도화 필요
    	Member member = this.memberService.retrieveMember(loginId);
    	System.out.println(shaPasswordEncoder.encodePassword(member.getPassword(), member.getId()));
        // 역할 별로 권한 나눠야 한다. 우선 하드코딩.
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (member.getType() == Integer.parseInt(MemberType.ADMIN.getCode())) {
        	authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (member.getType() == Integer.parseInt(MemberType.CROCODILE.getCode())){
        	authorities.add(new SimpleGrantedAuthority("ROLE_CROCODILE"));
        }

        // spring security 의 UserDetails 객체로 변환
        UserDetails userDetails = new SecurityUserDetails(member.getId(), member.getPassword(), authorities);
        
        return userDetails;
    }

}
