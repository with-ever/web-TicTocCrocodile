package kr.whenever.crocodile.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.whenever.crocodile.domain.Member;
import kr.whenever.crocodile.domain.common.member.MemberType;
import kr.whenever.crocodile.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		String redirectUrl = "/";
		
		// TODO 사용자 저장할 수 있는 방법 모색.
		HttpSession session = request.getSession();
		session.setAttribute("memberId", authentication.getName());
		
		Member member = this.memberService.retrieveMember(authentication.getName());
		if (Integer.toString(member.getType()).equals(MemberType.ADMIN.getCode())) {
			redirectUrl = "/admin";
		}
		response.sendRedirect(redirectUrl);
	}
}
