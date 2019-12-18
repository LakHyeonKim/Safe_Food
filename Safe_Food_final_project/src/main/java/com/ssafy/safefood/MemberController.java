
package com.ssafy.safefood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.service.MemberService;
import com.ssafy.safefood.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("signup.do")
	public ModelAndView registerMember(HttpServletRequest request, HttpServletResponse response, Member vo) throws Exception {
		memberService.registerMember(vo);
		return new ModelAndView("redirect:index.jsp");
	}

	@RequestMapping("update.do")
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response, Member vo) throws Exception {
		memberService.updateMember(vo);
		return new ModelAndView("index");
	}

	@RequestMapping("delete.do")
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		Member vo = (Member) session.getAttribute("user");
		memberService.deleteMember(vo.getId());
		session.invalidate();
		return new ModelAndView("index");
	}

	@RequestMapping("findById.do")//여기서 id받아서 찾아줘야 개인정보 수정해도 갱신이됨
	public ModelAndView findMemberById(HttpServletRequest request, HttpServletResponse response, Member vo) throws Exception {
//		System.out.println(request.getParameter("id"));
		Member rvo = memberService.findMemberById(vo);
		return new ModelAndView("MemberInfo","user",rvo);
	}


	@RequestMapping("idcheck.do")
	public ModelAndView idcheck(HttpServletRequest request, HttpServletResponse response, String id) throws Exception{
		//결과 페이지는 idcheck.jsp
		//service의 idcheck()를 수행한 결과가 String으로 리턴..
		//이 String은 id니까 id가 있다면 flag값을 true로 세팅...이값을 바인딩해서 넘겨주자..
		String result = (String)memberService.idcheck(id);
		boolean flag = false;
		if(result != null)	flag = true; 
		return new ModelAndView("idcheck","flag",flag);
	}
	
	@RequestMapping("findPassById.do")
	public ModelAndView findPassById(HttpServletRequest request, HttpServletResponse response, HttpSession session, Member vo) throws Exception {
		String path = "findPassword_fail";
		Member rvo = memberService.findPassById(vo);
		if(rvo != null)	{//일치하는 회원이 있으면
			request.setAttribute("user", rvo);
			path = "findPassword_ok";
		}
		return new ModelAndView(path);
	}

	@RequestMapping("login.do")//로그인 할때 id비번으로 객체받아서 맞는 id비번을 찾아 회원 객체 반환한다.
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Member vo) throws Exception {
		String path = "login_fail";
		Member rvo = memberService.login(vo);
		if(rvo != null)	{//로그인 성공했다면
			session.setAttribute("user", rvo);
			path = "redirect:index.jsp";
		}
		return new ModelAndView(path);
	}
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		if(session.getAttribute("user") != null) session.invalidate();
		return new ModelAndView("redirect:index.jsp");
	}
}

